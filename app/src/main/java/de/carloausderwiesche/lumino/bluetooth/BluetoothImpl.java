package de.carloausderwiesche.lumino.bluetooth;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.widget.Toast;

import de.carloausderwiesche.lumino.MainActivity;

public class BluetoothImpl implements IBluetooth {
    private static BluetoothImpl singleton = null;
    private BluetoothAdapter btAdapter;

    private BluetoothImpl(){
        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public static BluetoothImpl getBluetoothComponent() {
        if (BluetoothImpl.singleton == null){
            BluetoothImpl.singleton = new BluetoothImpl();
        }
        return BluetoothImpl.singleton;
    }

    @Override
    public void enableBluetooth() {

    }



}
