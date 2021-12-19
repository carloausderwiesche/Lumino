package de.carloausderwiesche.lumino.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.LinkedList;

@Entity(tableName = "scene_table")
public class Scene {
    @Ignore
    private static Scene singleton = null;

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String titel;
    private String caption;
    private String pattern;
    private long delay;

    public Scene(String titel, String caption, String pattern, long delay) {
        this.titel = titel;
        this.caption = caption;
        this.pattern = pattern;
        this.delay = delay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Scene getSceneComponent(){
        if (Scene.singleton == null){
          //  Scene.singleton = new Scene();
        }
        return Scene.singleton;
    }

    public static Scene getSingleton() {
        return singleton;
    }

    public int getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getCaption() {
        return caption;
    }

    public String getPattern() {
        return pattern;
    }

    public long getDelay() {
        return delay;
    }
}
