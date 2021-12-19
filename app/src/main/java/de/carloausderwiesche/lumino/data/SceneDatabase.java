package de.carloausderwiesche.lumino.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Scene.class, version = 1)
public abstract class SceneDatabase extends RoomDatabase {

    private static SceneDatabase singleton;


    public abstract SceneDAO sceneDAO();

    public static synchronized SceneDatabase getSingleton(Context context){
        if (singleton == null){
            singleton = Room.databaseBuilder(context.getApplicationContext(), SceneDatabase.class, "scene_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return singleton;
    }
}
