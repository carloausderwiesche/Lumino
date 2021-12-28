package de.carloausderwiesche.lumino.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scene_table")
public class Scene {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int icon;
    private String pattern;
    private long delay;


    public Scene(String title, String description, int icon, String pattern, long delay) {
        this.title = title;
        this.description = description;
        this.icon = icon;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
