package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import de.carloausderwiesche.lumino.view.client.ClientActivity;
import de.carloausderwiesche.lumino.view.host.HostActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnHostSession;
    private Button btnJoinSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHostSession = findViewById(R.id.btn_hostSession);
        btnHostSession.setOnClickListener(v -> openActivityHost());

        btnJoinSession = findViewById(R.id.btn_joinSession);
        btnJoinSession.setOnClickListener(v -> openActivityClient());

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
