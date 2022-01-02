package de.carloausderwiesche.lumino.controller.host;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.bluetooth.BluetoothImpl;
import de.carloausderwiesche.lumino.controller.host.HostControllerImpl;
import de.carloausderwiesche.lumino.view.SceneActivity;

public class HostActivity extends AppCompatActivity {
    private HostControllerImpl hostController;
    private Button btnStartScene;
    private Button btnSelectScene;
    private TextView textViewSelectedScene;
    private BluetoothImpl bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        //init when hostscreen appears
        // TODO: startBluetoothHost();
        bluetooth = BluetoothImpl.getBluetoothComponent(this);


        textViewSelectedScene = findViewById(R.id.selectedScene_host);
        hostController = HostControllerImpl.getHostControllerImpl(this, textViewSelectedScene);

        //START BUTTON
        btnStartScene = findViewById(R.id.btn_hostStartScene);
        btnStartScene.setOnClickListener(v -> hostController.buttonStartPressed(btnStartScene));

        //SELECT SCENES BUTTON
        btnSelectScene = findViewById(R.id.btn_hostSelectScene);
        btnSelectScene.setOnClickListener(v -> openActivitySceneRecycler());
    }


    private void openActivitySceneRecycler() {
        Intent intent = new Intent(this, SceneActivity.class);
        startActivity(intent);
    }
}