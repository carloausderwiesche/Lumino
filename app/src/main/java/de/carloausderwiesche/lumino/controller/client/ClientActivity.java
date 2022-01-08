package de.carloausderwiesche.lumino.controller.client;

import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_CONNECTED;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_CONNECTING;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_CONNECTION_FAILED;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_LISTENING;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_MESSAGE_RECEIVED;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.TextView;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.bluetooth.BluetoothClient;
import de.carloausderwiesche.lumino.bluetooth.BluetoothImpl;
import de.carloausderwiesche.lumino.view.scene.SceneTitleClient;

public class ClientActivity extends AppCompatActivity {
    private SceneTitleClient sceneTitleClient;
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
            bluetoothClient.onDeviceItemClick(position);
        }));





    }
}