package de.carloausderwiesche.lumino.view.scene;

import android.widget.TextView;

import de.carloausderwiesche.lumino.data.Scene;


public class SceneTitleClient {
    private static SceneTitleClient singleton = null;
    private TextView textViewClientSelectedScene;

    private SceneTitleClient(TextView textView){
        this.textViewClientSelectedScene = textView;
    }


    public static SceneTitleClient getSceneTextViewChange(TextView textView){
        if (singleton == null) {
            singleton = new SceneTitleClient(textView);
        }
        return singleton;
    }

    public static SceneTitleClient getSingleton(){
        return singleton;
    }

    public void changeCurrentSceneTextViews(Scene scene){
        textViewClientSelectedScene.setText(scene.getTitle());
    }



}
