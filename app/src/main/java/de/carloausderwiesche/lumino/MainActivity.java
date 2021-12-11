package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.carloausderwiesche.lumino.bluetooth.BluetoothImpl;

public class MainActivity extends AppCompatActivity {
    private Button btnHostSession;
    private Button btnJoinSession;
    private static Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();

        btnHostSession = findViewById(R.id.btn_hostSession);
        btnHostSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHost();
                startBluetoothHost();
            }
        });

        btnJoinSession = findViewById(R.id.btn_joinSession);
        btnJoinSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityClient();
            }
        });

    }

    public static Context getAppContext(){
        return appContext;
    }

    private void openActivityHost() {
        Intent intent = new Intent(this, HostActivity.class);
        startActivity(intent);
    }

    private void openActivityClient() {
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    private void startBluetoothHost() {
        BluetoothImpl bt = new BluetoothImpl();

    }
}
