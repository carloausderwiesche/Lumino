package de.carloausderwiesche.lumino.view.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.bluetooth.BluetoothClient;
import de.carloausderwiesche.lumino.controller.client.ClientControllerImpl;

public class ClientConnectedScreen extends AppCompatActivity {
    private TextView txt_currentSceneTitle;
    private Button btn_leaveSession;
    private ClientControllerImpl clientController;
    private BluetoothClient bluetoothClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_connected_screen);

        txt_currentSceneTitle = findViewById(R.id.client_selectedScene);
        btn_leaveSession = findViewById(R.id.btn_clientLeaveSession);
        clientController = ClientControllerImpl.getClientController(this, txt_currentSceneTitle, btn_leaveSession);
        bluetoothClient = BluetoothClient.getSingleton();

    }
}