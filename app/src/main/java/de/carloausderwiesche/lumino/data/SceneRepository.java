package de.carloausderwiesche.lumino.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SceneRepository {
    private SceneDAO sceneDAO;
    private LiveData<List<Scene>> allScenes;

    public SceneRepository(Application application){
        SceneDatabase database = SceneDatabase.getDatabase(application);
        sceneDAO = database.sceneDAO();
        allScenes = sceneDAO.getAllScenes();
    }

    public void insert(Scene scene){
        SceneDatabase.databaseWriteExecutor.execute(() -> sceneDAO.insert(scene));
    }

    public LiveData<List<Scene>> getAllScenes() {
        return allScenes;
    }
}