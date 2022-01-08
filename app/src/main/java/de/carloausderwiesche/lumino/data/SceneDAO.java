package de.carloausderwiesche.lumino.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SceneDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Scene scene);

    @Query("SELECT * FROM scene_table ORDER BY id")
    LiveData<List<Scene>> getAllScenes();

    @Query("DELETE FROM scene_table;")
    void deleteAll();
}
