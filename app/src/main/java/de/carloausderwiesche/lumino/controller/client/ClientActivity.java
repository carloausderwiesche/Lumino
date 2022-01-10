package de.carloausderwiesche.lumino.controller.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.bluetooth.BluetoothClient;
import de.carloausderwiesche.lumino.view.client.ClientConnectedScreen;


public class ClientActivity extends AppCompatActivity {
    private BluetoothClient bluetoothClient;
    private ListView listViewDevices;
    private TextView txt_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_device_selection);

        txt_status = findViewById(R.id.txt_status);
        listViewDevices = findViewById(R.id.bluetoothDiscoveredDevices);
        bluetoothClient = BluetoothClient.getBluetoothClientComponent(listViewDevices, txt_status, this);

        bluetoothClient.startBluetooth(this);
        bluetoothClient.listDevices(getApplicationContext());

        listViewDevices.setOnItemClickListener(((parent, view, position, id) -> {
            if (bluetoothClient.joinSession(position)) {
                openActivityClientConnected();
            }
        }));
    }

    private void openActivityClientConnected() {
        Intent intent = new Intent(this, ClientConnectedScreen.class);
        startActivity(intent);
    }
}