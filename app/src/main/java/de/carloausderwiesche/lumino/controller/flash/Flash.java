package de.carloausderwiesche.lumino.controller.flash;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import de.carloausderwiesche.lumino.MainActivity;
import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.data.Scene;

public class Flash implements Runnable {
    private static Flash singleton = null;
    CameraManager cameraManager;
    private Scene currentScene;
    private volatile boolean pause;
    String cameraID;
    private TextView textViewSelectedScene;

    private Flash(Context context, TextView textViewSelectedScene) {
        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraID = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        this.textViewSelectedScene = textViewSelectedScene;
        currentScene = new Scene("Test", "blublub", R.drawable.sceneicon__party, "101010", 100);
        pause = false;

        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                Toast.makeText(context, "This device has flash", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "This device has no flash", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "This device has no camera", Toast.LENGTH_SHORT).show();
        }
    }

    public static Flash getFlashComponent(Context context, TextView textViewSelectedScene) {
        if (Flash.singleton == null) {
            Flash.singleton = new Flash(context, textViewSelectedScene);
        }
        return Flash.singleton;
    }

    public static Flash getFlashComponent() {
        return Flash.singleton;
    }

    private void turnFlashOn() {
        try {
            cameraManager.setTorchMode(cameraID, true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void turnFlashOff() {
        try {
            cameraManager.setTorchMode(cameraID, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void blinkFlash() {
        String pattern = currentScene.getPattern();
        long delay = currentScene.getDelay();
        pause = false;

        while (!pause) {
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '1') {
                    turnFlashOn();
                } else turnFlashOff();

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        turnFlashOff();
    }

    public void pauseBlinkFlash() {
        pause = true;
    }

    public void setScene(Scene selectedScene, View itemView) {
        // TextView sceneTitle;
        currentScene = selectedScene;
        //sceneTitle = itemView.findViewById(R.id.selectedScene_host);
        //sceneTitle.setText(currentScene.getTitle());

        textViewSelectedScene.setText(currentScene.getTitle());
    }

    @Override
    public void run() {
        blinkFlash();
    }
}
