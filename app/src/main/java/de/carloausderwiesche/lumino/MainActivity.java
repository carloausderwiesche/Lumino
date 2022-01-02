package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import de.carloausderwiesche.lumino.controller.client.ClientActivity;
import de.carloausderwiesche.lumino.controller.host.HostActivity;
import de.carloausderwiesche.lumino.view.scene.SceneTitleClient;

public class MainActivity extends AppCompatActivity {
    private Button btnHostSession;
    private Button btnJoinSession;
    private static Context appContext;
    private static Object systemCameraService;
    private SceneTitleClient sceneTitleClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();
        systemCameraService = getSystemService(CAMERA_SERVICE);

        btnHostSession = findViewById(R.id.btn_hostSession);
        btnHostSession.setOnClickListener(v -> openActivityHost());

       btnJoinSession = findViewById(R.id.btn_joinSession);
       btnJoinSession.setOnClickListener(v -> openActivityClient());

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
