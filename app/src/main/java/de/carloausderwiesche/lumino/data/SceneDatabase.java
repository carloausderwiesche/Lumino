package de.carloausderwiesche.lumino.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.carloausderwiesche.lumino.R;

@Database(entities = {Scene.class}, version = 2, exportSchema = false)
public abstract class SceneDatabase extends RoomDatabase {

    public abstract SceneDAO sceneDAO();

    private static volatile SceneDatabase SINGLETON;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static final String DATABASE_NAME = "scene_database";


    static SceneDatabase getDatabase(final Context context){
        if (SINGLETON == null) {
            synchronized (SceneDatabase.class) {
                if (SINGLETON == null) {
                    SINGLETON = Room.databaseBuilder(context.getApplicationContext(), SceneDatabase.class, DATABASE_NAME)
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return SINGLETON;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                SceneDAO sceneDAO = SINGLETON.sceneDAO();
                sceneDAO.deleteAll();

                sceneDAO.insert(new Scene("Shine", "Continuous light", R.drawable.sceneicon__torch, "11", 0));
                sceneDAO.insert(new Scene("blink fast", "fast blinking", R.drawable.sceneicon__party, "10", 30));
                sceneDAO.insert(new Scene("blink slow", "slow blinking", R.drawable.sceneicon__sos, "10", 300));
            });
        }
    };

}
