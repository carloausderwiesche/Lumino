package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnHostSession;
    private Button btnJoinSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHostSession = findViewById(R.id.btn_hostSession);
        btnHostSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHost();
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

    private void openActivityClient() {
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    private void openActivityHost() {
        Intent intent = new Intent(this, HostActivity.class);
        startActivity(intent);
    }
}
