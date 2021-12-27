package de.carloausderwiesche.lumino.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "scene_table")
public class Scene {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String pattern;
    private long delay;

    public Scene(String title, String description, String pattern, long delay) {
        this.title = title;
        this.description = description;
        this.pattern = pattern;
        this.delay = delay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPattern() {
        return pattern;
    }

    public long getDelay() {
        return delay;
    }
}
