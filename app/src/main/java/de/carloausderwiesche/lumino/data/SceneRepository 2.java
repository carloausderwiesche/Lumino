package de.carloausderwiesche.lumino.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SceneRepository {
    private SceneDAO sceneDAO;
    private LiveData<List<Scene>> allScenes;

    public SceneRepository(Application application){
        SceneDatabase database = SceneDatabase.getSingleton(application);
        sceneDAO = database.sceneDAO();
        allScenes = sceneDAO.getAllScenes();
    }

    public void insert(Scene scene){
        new InsertSceneAsyncTask(sceneDAO).execute(scene);
    }

    public void update(Scene scene){

    }

    public void delete(Scene scene){

    }

    public LiveData<List<Scene>> getAllScenes() {
        return allScenes;
    }

    private static class InsertSceneAsyncTask extends AsyncTask<Scene, Void, Void>{
        private SceneDAO sceneDAO;

        private InsertSceneAsyncTask(SceneDAO sceneDAO){
            this.sceneDAO = sceneDAO;
        }

        @Override
        protected Void doInBackground(Scene... scenes) {
            sceneDAO.insert(scenes[0]);
            return null;
        }
    }

}


//https://www.youtube.com/watch?v=HhmA9S53XV8