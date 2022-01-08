package de.carloausderwiesche.lumino.bluetooth;

public interface BluetoothStates {
    static final int STATE_LISTENING = 1;
    static final int STATE_CONNECTING = 2;
    static final int STATE_CONNECTED = 3;
    static final int STATE_CONNECTION_FAILED = 4;
    static final int STATE_MESSAGE_RECEIVED = 5;

    static final int REQUEST_ENABLE_BT = 0;
}
