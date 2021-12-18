package de.carloausderwiesche.lumino.controller.host;

import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.data.Scene;

public class HostControllerImpl implements IHostController {
    private static HostControllerImpl singleton = null;
    private Scene currentScene;
    private Flash flash;

    private HostControllerImpl(){
        flash = Flash.getFlashComponent();
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
        flash.blinkFlash(currentScene.getPattern(), currentScene.getDelay());
    }

    @Override
    public void pauseScene() {

    }

    @Override
    public Scene selectScene() {
        return null;
    }

    @Override
    public void endSession() {

    }
}
