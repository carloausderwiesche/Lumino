package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import de.carloausderwiesche.lumino.controller.client.ClientActivity;
import de.carloausderwiesche.lumino.controller.host.HostActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 0;
    private Button btnHostSession;
    private Button btnJoinSession;
    private static Context appContext;
    private static Object systemCameraService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();
        systemCameraService = getSystemService(CAMERA_SERVICE);

        btnHostSession = findViewById(R.id.btn_hostSession);
        btnHostSession.setOnClickListener(v -> openActivityHost());

       // btnJoinSession = findViewById(R.id.btn_joinSession);
       // btnJoinSession.setOnClickListener(v -> openActivityClient());


        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();

        if (!btAdapter.isEnabled()){
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        //Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        //startActivityForResult(enableBtIntent, 1);
    }

    public static Context getAppContext(){
        return appContext;
    }

    public static Object getSystemCameraService() {
        return systemCameraService;
    }

    private void openActivityHost() {
        Intent intent = new Intent(this, HostActivity.class);
        startActivity(intent);
    }

    private void openActivityClient() {
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }
}
