package de.carloausderwiesche.lumino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_hostSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_hostSession = findViewById(R.id.btn_hostSession);
        btn_hostSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHost();
            }
        });
    }

    private void openActivityHost() {
        Intent intent = new Intent(this, HostActivity.class);
        startActivity(intent);
    }
}
