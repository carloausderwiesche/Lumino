package de.carloausderwiesche.lumino.controller.flash;

import de.carloausderwiesche.lumino.data.Scene;

/**
 * Interface for flash control
 */
public interface IFlash {
    /**
     * executes current scene
     */
    void blinkFlash();

    /**
     * stops active scene
     */
    void pauseBlinkFlash();

    /**
     * changes current scene
     * @param selectedScene - new scene which will be selected
     */
    void setScene(Scene selectedScene);

    /**
     * @return currently selected scene
     */
    Scene getCurrentScene();
}
