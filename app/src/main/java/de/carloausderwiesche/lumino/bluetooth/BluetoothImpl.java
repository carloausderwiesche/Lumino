package de.carloausderwiesche.lumino.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
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
    public boolean enableBluetooth() {
        if (btAdapter == null){
            Toast.makeText(MainActivity.getAppContext(), "No bluetooth adapter available", Toast.LENGTH_SHORT).show();
            return false;
        } else Toast.makeText(MainActivity.getAppContext(), "Bluetooth adapter available", Toast.LENGTH_SHORT).show();

        if (btAdapter.isEnabled()) return true;


        return  true;
    }



}
