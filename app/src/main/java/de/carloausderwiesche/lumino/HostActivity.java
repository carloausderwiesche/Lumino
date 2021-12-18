package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import de.carloausderwiesche.lumino.bluetooth.BluetoothImpl;
import de.carloausderwiesche.lumino.controller.host.HostControllerImpl;

public class HostActivity extends AppCompatActivity {
    private HostControllerImpl hostController;
    private Button btnStartScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        //init when hostscreen appears
        startBluetoothHost();
        hostController = HostControllerImpl.getHostControllerImpl();

        //START BUTTON
        btnStartScene = findViewById(R.id.btn_hostStartScene);
        btnStartScene.setOnClickListener(v -> {
            btnStartScene.setText("STOP");
            hostController.startScene();
        });
    }


    private void startBluetoothHost() {
        BluetoothImpl bluetooth = BluetoothImpl.getBluetoothComponent();
        bluetooth.enableBluetooth();
    }
}