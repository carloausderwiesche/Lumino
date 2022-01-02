package de.carloausderwiesche.lumino.view.scene;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import de.carloausderwiesche.lumino.data.Scene;
import de.carloausderwiesche.lumino.data.SceneRepository;

public class SceneViewModel extends AndroidViewModel {
    private SceneRepository sceneRepository;
    private final LiveData<List<Scene>> allScenes;


    public SceneViewModel(@NonNull Application application) {
        super(application);
        sceneRepository = new SceneRepository(application);
        allScenes = sceneRepository.getAllScenes();
    }

    public void insert(Scene scene){
        sceneRepository.insert(scene);
    }

    public LiveData<List<Scene>> getAllScenes(){
        return allScenes;
    }

}
