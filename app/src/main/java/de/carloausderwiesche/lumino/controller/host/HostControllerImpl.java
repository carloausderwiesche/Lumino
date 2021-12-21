package de.carloausderwiesche.lumino.controller.host;

import android.content.Context;

import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.data.Scene;

public class HostControllerImpl implements IHostController {
    private static HostControllerImpl singleton = null;
    private Flash flash;
    private Thread blinkFlashThread;

    private HostControllerImpl(Context context){
        flash = Flash.getFlashComponent(context);
        blinkFlashThread = new Thread(flash);

    }

    public static HostControllerImpl getHostControllerImpl(Context context){
        if (HostControllerImpl.singleton == null){
            HostControllerImpl.singleton = new HostControllerImpl(context);
        }
        return HostControllerImpl.singleton;
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
