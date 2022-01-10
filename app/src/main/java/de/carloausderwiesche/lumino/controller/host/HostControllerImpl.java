package de.carloausderwiesche.lumino.controller.host;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.controller.flash.PlayingLightScene;
import de.carloausderwiesche.lumino.data.Scene;

public class HostControllerImpl implements IHostController {
    private static HostControllerImpl singleton = null;
    private Flash flash;
    private Thread blinkFlashThread;
    private boolean isBlinking;
    private Context context;
    private TextView textViewSelectedScene;
    private Button startStopButton;
    private PlayingLightScene playingLightScene;

    private HostControllerImpl(Context context, TextView textViewSelectedScene, Button startStopButton) {
        this.context = context;
        this.textViewSelectedScene = textViewSelectedScene;
        this.startStopButton = startStopButton;
        playingLightScene = PlayingLightScene.getPlayingLightScene();
        flash = Flash.getFlashComponent(context);
        isBlinking = false;
    }

    public static HostControllerImpl getHostControllerImpl(Context context, TextView textViewSelectedScene, Button startStopButton) {
        if (HostControllerImpl.singleton == null) {
            HostControllerImpl.singleton = new HostControllerImpl(context, textViewSelectedScene, startStopButton);
        }
        return HostControllerImpl.singleton;
    }

    public static HostControllerImpl getSingleton() {
        return singleton;
    }

    public void setCurrentSceneTitle(String title) {
        textViewSelectedScene.setText(title);
    }

    public void setStartStopButton(String text) {
        startStopButton.setText(text);
    }

    @Override
    public void buttonStartPressed(Button button) {
        try {
            playingLightScene.toogleLightSceneHost(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endSession() {

    }

}
