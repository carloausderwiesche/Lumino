package de.carloausderwiesche.lumino.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Scene.class, version = 1)
public abstract class SceneDatabase extends RoomDatabase {

    private static SceneDatabase singleton;


    public abstract SceneDAO sceneDAO();

    public static synchronized SceneDatabase getSingleton(Context context){
        if (singleton == null){
            singleton = Room.databaseBuilder(context.getApplicationContext(), SceneDatabase.class, "scene_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return singleton;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(singleton).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private SceneDAO sceneDAO;

        private PopulateDBAsyncTask(SceneDatabase sceneDatabase){
            sceneDAO = sceneDatabase.sceneDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            sceneDAO.insert(new Scene("Shine", "Continuous light", "11111", 0));
            sceneDAO.insert(new Scene("blink fast", "fast blinking", "1010101010101", 30));
            sceneDAO.insert(new Scene("blink slow", "slow blinking", "1010101010101", 300));
            return null;
        }
    }

}
