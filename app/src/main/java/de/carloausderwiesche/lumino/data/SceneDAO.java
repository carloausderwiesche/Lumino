package de.carloausderwiesche.lumino.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Interface for accessing data objects
 */
@Dao
public interface SceneDAO {

    /**
     * inserts scene into database
     * @param scene which will be added to database
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Scene scene);

    /**
     * @return all database objects in a list
     */
    @Query("SELECT * FROM scene_table ORDER BY id")
    LiveData<List<Scene>> getAllScenes();


    /**
     * deletes all database entities
     */
    @Query("DELETE FROM scene_table;")
    void deleteAll();
}
