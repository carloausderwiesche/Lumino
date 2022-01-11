package de.carloausderwiesche.lumino.controller.flash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.carloausderwiesche.lumino.bluetooth.BluetoothConnectionManager;
import de.carloausderwiesche.lumino.controller.client.ClientControllerImpl;
import de.carloausderwiesche.lumino.view.host.HostControllerImpl;
import de.carloausderwiesche.lumino.data.Scene;

public class PlayingLightScene implements IPlayingLightScene{
    private static PlayingLightScene singleton = null;
    private Scene currentScene;
    private Thread sceneThread;
    private boolean isPlaying;
    private HostControllerImpl hostController;
    private ClientControllerImpl clientController;
    private Handler handler;
    private BluetoothConnectionManager bluetoothConnectionManager;

    private PlayingLightScene() {
        isPlaying = false;
        handler = new Handler(Looper.getMainLooper());
    }

    public static PlayingLightScene getPlayingLightScene() {
        if (singleton == null) {
            singleton = new PlayingLightScene();
        }
        return singleton;
    }


    public void toogleLightSceneHost(Context context) throws IOException {

        if (hostController == null) hostController = HostControllerImpl.getSingleton();
        Flash hostFlash = Flash.getFlashComponent(context);
        this.currentScene = hostFlash.getCurrentScene();

        if (!isPlaying) {
            currentScene.setRunning(true);
            if (bluetoothConnectionManager != null) bluetoothConnectionManager.write(convertSceneToByteArray());
            sceneThread = new Thread(hostFlash);
            sceneThread.start();
            handler.post(() -> {
                // hostController.setCurrentSceneTitle(currentScene.getTitle());
                hostController.setStartStopButton("STOP");
            });
            isPlaying = true;
        } else {
            currentScene.setRunning(false);
            if (bluetoothConnectionManager != null) bluetoothConnectionManager.write(convertSceneToByteArray());
            hostFlash.pauseBlinkFlash();
            handler.post(() -> {
                hostController.setStartStopButton("START");
            });
            isPlaying = false;
        }
    }


    public void toogleLightSceneClient(byte[] message) throws IOException, ClassNotFoundException {
        this.currentScene = convertByteArrayToScene(message);
        if (clientController == null) clientController = ClientControllerImpl.getSingleton();
        Flash clientFlash = Flash.getFlashComponent(clientController.getContext());

        if (currentScene.isRunning()) {
            clientFlash.setScene(currentScene);
            clientController.setCurrentSceneTitle(currentScene.getTitle());
            sceneThread = new Thread(clientFlash);
            sceneThread.start();
            isPlaying = true;
        } else {
            clientFlash.pauseBlinkFlash();
            isPlaying = false;
        }

    }

    public void setSceneTitleHost(String title) {
        hostController = HostControllerImpl.getSingleton();
        if (!(hostController == null)) hostController.setCurrentSceneTitle(title);
    }

    public void setBCM(BluetoothConnectionManager bcm) {
        if (bcm != null) {
            this.bluetoothConnectionManager = bcm;
        }
    }

    private byte[] convertSceneToByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(baos)) {
            ois.writeObject(currentScene);
            ois.flush();
            return baos.toByteArray();
        }
    }

    private Scene convertByteArrayToScene(byte[] message) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(message);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (Scene) ois.readObject();
        }
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}
