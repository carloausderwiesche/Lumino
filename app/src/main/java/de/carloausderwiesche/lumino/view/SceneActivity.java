package de.carloausderwiesche.lumino.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.view.SceneViewAdapter;
import de.carloausderwiesche.lumino.view.SceneViewModel;

public class SceneActivity extends AppCompatActivity {
    private SceneViewModel sceneViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_scenes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final SceneViewAdapter adapter = new SceneViewAdapter();
        recyclerView.setAdapter(adapter);

        //load scenes
        sceneViewModel = new ViewModelProvider(this).get(SceneViewModel.class);
        sceneViewModel.getAllScenes().observe(this, scenes -> {
            adapter.setScenes(scenes);
        });

    }
}