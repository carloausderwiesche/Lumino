package de.carloausderwiesche.lumino.controller.flash;

import android.content.Context;

import java.io.IOException;

public interface IPlayingLightScene {

    void toogleLightSceneHost(Context context) throws IOException;
    void toogleLightSceneClient(byte[] message) throws IOException, ClassNotFoundException;
    void setSceneTitleHost(String title);
}
