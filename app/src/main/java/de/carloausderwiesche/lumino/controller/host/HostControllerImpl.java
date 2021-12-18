package de.carloausderwiesche.lumino.controller.host;

import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.data.Scene;

public class HostControllerImpl implements IHostController {
    private static HostControllerImpl singleton = null;
    private Flash flash;
    private Thread blinkFlashThread;

    private HostControllerImpl(){
        flash = Flash.getFlashComponent();
        blinkFlashThread = new Thread(flash);

    }

    public static HostControllerImpl getHostControllerImpl(){
        if (HostControllerImpl.singleton == null){
            HostControllerImpl.singleton = new HostControllerImpl();
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
