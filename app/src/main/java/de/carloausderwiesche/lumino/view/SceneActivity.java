package de.carloausderwiesche.lumino.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
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
        final SceneListAdapter adapter = new SceneListAdapter(new SceneListAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}