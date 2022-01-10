package de.carloausderwiesche.lumino.bluetooth;

import android.app.Activity;
import android.content.Context;

/**
 * Interface for Client to join session
 */
public interface IBluetoothClient {
    /**
     * enables default bluetooth adapter if not enabled yet
     * @return
     */
    void startBluetooth(Activity activity);

    /**
     * displays bluetooth devices
     * @param context
     */
    void listDevices(Context context);

    /**
     * joins selected host session
     * @param position in listView
     */
    boolean joinSession(int position);

    /**
     * leaves current session
     */
    void leaveSession();
}
