package de.carloausderwiesche.lumino.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.carloausderwiesche.lumino.R;
import de.carloausderwiesche.lumino.controller.flash.Flash;
import de.carloausderwiesche.lumino.controller.host.HostControllerImpl;
import de.carloausderwiesche.lumino.data.Scene;

public class SceneActivity extends AppCompatActivity {
    public static final int NEW_SCENE_ACTIVITY_REQUEST_CODE = 1;
    private SceneViewModel sceneViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_scenes);
        final SceneListAdapter adapter = new SceneListAdapter(new SceneListAdapter.SceneDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sceneViewModel = new ViewModelProvider(this).get(SceneViewModel.class);

        sceneViewModel.getAllScenes().observe(this, scenes -> adapter.submitList(scenes));

        FloatingActionButton fab = findViewById(R.id.fab_addNewScene);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(SceneActivity.this, NewSceneActivity.class);
            startActivityForResult(intent, NEW_SCENE_ACTIVITY_REQUEST_CODE);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_SCENE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Scene scene = new Scene(data.getStringExtra(NewSceneActivity.EXTRA_REPLY), "Test", R.drawable.sceneicon_custom, "110110", 3);
            sceneViewModel.insert(scene);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}