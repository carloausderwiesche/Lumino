package de.carloausderwiesche.lumino.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SceneRepository {
    private SceneDAO sceneDAO;
    private LiveData<List<Scene>> allScenes;

    public SceneRepository(Application application){
        SceneDatabase database = SceneDatabase.getSingleton(application);
    }
}


//https://www.youtube.com/watch?v=HhmA9S53XV8