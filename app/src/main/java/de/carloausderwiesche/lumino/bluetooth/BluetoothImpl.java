package de.carloausderwiesche.lumino.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.widget.Toast;

public class BluetoothImpl implements IBluetooth {
    private BluetoothAdapter btAdapter;

    public BluetoothImpl(){
        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public boolean enableBluetooth() {
        if (btAdapter == null){
            //TODO: Toast pop up
            //Toast.makeText(this,"Bluetooth not supported!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (btAdapter.isEnabled()) return true;


        return  true;
    }



}
