package de.carloausderwiesche.lumino.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.widget.Toast;

import de.carloausderwiesche.lumino.MainActivity;

public class BluetoothImpl implements IBluetooth {
    private BluetoothAdapter btAdapter;

    public BluetoothImpl(){
        btAdapter = BluetoothAdapter.getDefaultAdapter();
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
