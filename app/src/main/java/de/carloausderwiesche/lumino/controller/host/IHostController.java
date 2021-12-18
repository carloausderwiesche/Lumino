package de.carloausderwiesche.lumino.controller.host;

import de.carloausderwiesche.lumino.data.Scene;

public interface IHostController {
    boolean createSession();
    void startScene();
    void pauseScene();
    Scene selectScene();
    void endSession();

}
