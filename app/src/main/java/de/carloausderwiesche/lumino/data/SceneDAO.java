package de.carloausderwiesche.lumino.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SceneDAO {

    @Insert
    void insert(Scene scene);

    @Update
    void update(Scene scene);

    @Delete
    void delete(Scene scene);

    @Query("SELECT * FROM scene_table ORDER BY id")
    LiveData<List<Scene>> getAllScenes();



}
