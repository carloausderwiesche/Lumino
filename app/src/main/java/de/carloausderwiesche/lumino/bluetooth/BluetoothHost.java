package de.carloausderwiesche.lumino.bluetooth;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.REQUEST_ENABLE_BT;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;

public class BluetoothHost implements IBluetoothHost {
    private static BluetoothHost singleton = null;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothHandler bluetoothHandler;
    private ServerAccept serverAccept;

    private BluetoothHost(Activity activity){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothHandler = BluetoothHandler.getBluetoothHandlerComponent(activity);
    }

    public static BluetoothHost getBluetoothHostComponent(Activity activity){
        if (singleton == null){
            singleton = new BluetoothHost(activity);
        }
        return singleton;
    }

    public void startBluetooth(Activity activity){
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(activity, enableBtIntent, REQUEST_ENABLE_BT, Bundle.EMPTY);
        }
    }

    public void startBluetoothHost(){
        serverAccept = new ServerAccept(bluetoothAdapter, bluetoothHandler.getHandler());
        serverAccept.start();
    }

    @Override
    public void endBluetoothHost() {
        serverAccept.cancel();
    }

}
