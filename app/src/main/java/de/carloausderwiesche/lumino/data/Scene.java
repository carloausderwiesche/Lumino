package de.carloausderwiesche.lumino.data;

import java.util.LinkedList;

public class Scene {
    private static Scene singleton = null;
    private int ID;
    private String name;
    private String caption;
    private String pattern;
    private long delay;

    private Scene(){
        pattern = "10101010101";
        delay = 500L;
    }

    public static Scene getSceneComponent(){
        if (Scene.singleton == null){
            Scene.singleton = new Scene();
        }
        return Scene.singleton;
    }


    public String getPattern() {
        return pattern;
    }

    public long getDelay() {
        return delay;
    }
}
