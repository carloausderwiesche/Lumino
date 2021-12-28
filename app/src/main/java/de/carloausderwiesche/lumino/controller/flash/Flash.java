package de.carloausderwiesche.lumino.controller.flash;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.widget.Switch;
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

    private Flash(Context context) {
        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraID = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

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

    public static Flash getFlashComponent(Context context) {
        if (Flash.singleton == null) {
            Flash.singleton = new Flash(context);
        }
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

    public void setScene(Scene selectedScene) {
        currentScene = selectedScene;
    }

    @Override
    public void run() {
        blinkFlash();
    }
}
