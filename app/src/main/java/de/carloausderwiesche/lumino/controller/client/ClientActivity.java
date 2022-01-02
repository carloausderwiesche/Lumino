package de.carloausderwiesche.lumino.controller.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.bluetooth.BluetoothImpl;
import de.carloausderwiesche.lumino.view.scene.SceneTitleClient;

public class ClientActivity extends AppCompatActivity {
    private SceneTitleClient sceneTitleClient;
    private BluetoothImpl bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_device_selection);

        bluetooth = BluetoothImpl.getBluetoothComponent();
        bluetooth.enableBluetooth(this);

        //Scene Title
        sceneTitleClient = SceneTitleClient.getSceneTextViewChange(findViewById(R.id.client_selectedScene));
    }
}