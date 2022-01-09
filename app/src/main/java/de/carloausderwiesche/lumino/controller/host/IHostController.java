package de.carloausderwiesche.lumino.controller.host;

import android.widget.Button;

import de.carloausderwiesche.lumino.data.Scene;

/**
 * Interface for Hostcontroller
 */
public interface IHostController {
    /**
     * starts or stops lightscene
     * @param button which was clicked
     */
    void buttonStartPressed(Button button);

    /**
     * ends current session
     */
    void endSession();
}
