package de.carloausderwiesche.lumino.bluetooth;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import de.carloausderwiesche.lumino.MainActivity;

public class BluetoothImpl implements IBluetooth {
    private static final int REQUEST_ENABLE_BT = 0;
    private static BluetoothImpl singleton = null;
    private BluetoothAdapter btAdapter;

    private BluetoothImpl(Activity activity){
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        enableBluetooth(activity);
    }

    public static BluetoothImpl getBluetoothComponent(Activity activity) {
        if (BluetoothImpl.singleton == null){
            BluetoothImpl.singleton = new BluetoothImpl(activity);
        }
        return BluetoothImpl.singleton;
    }

    @Override
    public void enableBluetooth(Activity activity) {
        if (!btAdapter.isEnabled()){
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(activity, enableBtIntent, REQUEST_ENABLE_BT, Bundle.EMPTY);
        }

    }



}
