package de.carloausderwiesche.lumino.controller.flash;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.widget.Switch;
import android.widget.Toast;

import de.carloausderwiesche.lumino.MainActivity;

public class Flash {

    private static Flash singleton = null;
    CameraManager cameraManager;

    private Flash(){
        cameraManager = (CameraManager) MainActivity.getSystemCameraService();

        if (MainActivity.getAppContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            if (MainActivity.getAppContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
                Toast.makeText(MainActivity.getAppContext(), "This device has flash", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.getAppContext(), "This device has no flash", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.getAppContext(), "This device has no camera", Toast.LENGTH_SHORT).show();
        }
    }

    public static Flash getFlashComponent(){
        if (Flash.singleton == null){
            Flash.singleton = new Flash();
        }
        return Flash.singleton;
    }

    private void turnFlashOn(){
        try {
            cameraManager.setTorchMode("0", true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void turnFlashOff(){
        try {
            cameraManager.setTorchMode("0", false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void blinkFlash(String pattern, long delay){
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '1'){
                turnFlashOn();
            } else turnFlashOff();
        }
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
