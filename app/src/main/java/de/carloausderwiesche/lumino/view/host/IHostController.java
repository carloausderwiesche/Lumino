package de.carloausderwiesche.lumino.view.host;

import android.widget.Button;

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
