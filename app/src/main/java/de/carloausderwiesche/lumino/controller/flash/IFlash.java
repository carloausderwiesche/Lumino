package de.carloausderwiesche.lumino.controller.flash;

import de.carloausderwiesche.lumino.data.Scene;

public interface IFlash {
    void blinkFlash();
    void pauseBlinkFlash();
    void setScene(Scene selectedScene);
}
