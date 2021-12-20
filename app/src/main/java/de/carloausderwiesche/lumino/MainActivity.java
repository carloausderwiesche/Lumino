package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.data.Scene;
import de.carloausderwiesche.lumino.view.SceneViewModel;

public class MainActivity extends AppCompatActivity {
    private Button btnHostSession;
    private Button btnJoinSession;
    private static Context appContext;
    private static Object systemCameraService;

    private SceneViewModel sceneViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();
        systemCameraService = getSystemService(CAMERA_SERVICE);

        btnHostSession = findViewById(R.id.btn_hostSession);
        btnHostSession.setOnClickListener(v -> {
            openActivityHost();
        });

        btnJoinSession = findViewById(R.id.btn_joinSession);
        btnJoinSession.setOnClickListener(v -> openActivityClient());

        //load scenes
        sceneViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SceneViewModel.class);
        sceneViewModel.getAllScenes().observe(this, new Observer<List<Scene>>() {
            @Override
            public void onChanged(List<Scene> scenes) {
                //update RecyclerView
                Toast.makeText(MainActivity.this, "on changed", Toast.LENGTH_SHORT).show();
            }
        });


        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBtIntent, 1);
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
