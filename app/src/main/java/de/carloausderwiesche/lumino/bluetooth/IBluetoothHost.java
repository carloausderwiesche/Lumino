package de.carloausderwiesche.lumino.bluetooth;

import android.app.Activity;

/**
 * Interface for Host to start and end bluetooth session
 */
public interface IBluetoothHost {
    /**
     * enables default bluetooth adapter if not enabled yet
     * @param activity
     */
    void startBluetooth(Activity activity);

    /**
     * starts bluetooth server thread and waits for incoming connections
     */
    void startBluetoothHost();
    void endBluetoothHost();
}
