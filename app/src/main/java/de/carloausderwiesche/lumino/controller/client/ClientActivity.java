package de.carloausderwiesche.lumino.controller.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.view.SceneTitleClient;

public class ClientActivity extends AppCompatActivity {
    private SceneTitleClient sceneTitleClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        sceneTitleClient = SceneTitleClient.getSceneTextViewChange(findViewById(R.id.client_selectedScene));
    }
}