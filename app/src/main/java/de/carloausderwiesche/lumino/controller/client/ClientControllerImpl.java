package de.carloausderwiesche.lumino.controller.client;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import de.carloausderwiesche.lumino.controller.flash.PlayingLightScene;

public class ClientControllerImpl implements IClientController {
    private static ClientControllerImpl singleton = null;
    private Context context;
    private TextView currentScene;
    private Button btnLeaveSession;
    private PlayingLightScene playingLightScene;

    private ClientControllerImpl(Context context, TextView currentScene, Button btnLeaveSession) {
        this.context = context;
        this.btnLeaveSession = btnLeaveSession;
        this.currentScene = currentScene;
        this.playingLightScene = PlayingLightScene.getPlayingLightScene();
    }

    public static ClientControllerImpl getClientController(Context context, TextView currentScene, Button btnLeaveSession){
        if (singleton == null){
            singleton = new ClientControllerImpl(context, currentScene, btnLeaveSession);
        }
        return singleton;
    }

    public static ClientControllerImpl getSingleton() {
        return singleton;
    }

    public void setCurrentSceneTitle(String title){
        currentScene.setText(title);
    }

    public Context getContext(){
        return context;
    }

    @Override
    public void joinSession() {

    }

    @Override
    public void setStatus(boolean status) {

    }

    @Override
    public void leaveSession() {

    }
}
