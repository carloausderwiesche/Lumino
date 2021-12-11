package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import de.carloausderwiesche.lumino.bluetooth.BluetoothImpl;

public class HostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        //init when hostscreen appears
        startBluetoothHost();
    }


    private void startBluetoothHost() {
        BluetoothImpl bluetooth = BluetoothImpl.getBluetoothComponent();
        bluetooth.enableBluetooth();
    }
}