package de.carloausderwiesche.lumino.controller.host;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.data.Scene;

public class HostControllerImpl implements IHostController {
    private static HostControllerImpl singleton = null;
    private Flash flash;
    private Thread blinkFlashThread;
    private boolean isBlinking;

    private HostControllerImpl(Context context, TextView textViewSelectedScene) {
        flash = Flash.getFlashComponent(context, textViewSelectedScene);
        isBlinking = false;
    }

    public static HostControllerImpl getHostControllerImpl(Context context, TextView textViewSelectedScene) {
        if (HostControllerImpl.singleton == null) {
            HostControllerImpl.singleton = new HostControllerImpl(context, textViewSelectedScene);
        }
        return HostControllerImpl.singleton;
    }

    public void buttonStartPressed(Button button) {
        Handler handler = new Handler(Looper.getMainLooper());

        if (!isBlinking) {
            blinkFlashThread = new Thread(flash);
            blinkFlashThread.start();
            handler.post(() -> button.setText("STOP"));
            isBlinking = true;
        } else {
            //blinkFlashThread.interrupt();
            flash.pauseBlinkFlash();
            handler.post(() -> button.setText("START"));
            isBlinking = false;
        }

        /*
        if (firstRun) {
            blinkFlashThread.start();
            handler.post(() -> button.setText("STOP"));
            isBlinking = true;
            firstRun = false;
        } else {
            if (!isBlinking) {
                handler.post(() -> button.setText("STOP"));
                flash.continueBlinkFlash();
                isBlinking = true;
            } else {
                handler.post(() -> button.setText("START"));
                flash.pauseBlinkFlash();
                isBlinking = false;
            }
        }
         */


    }


    @Override
    public boolean createSession() {
        return false;
    }

    @Override
    public void startScene() {
        blinkFlashThread.start();
    }

    @Override
    public void pauseScene() {
        flash.pauseBlinkFlash();
    }

    @Override
    public Scene selectScene() {
        return null;
    }

    @Override
    public void endSession() {

    }
}
