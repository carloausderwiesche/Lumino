package de.carloausderwiesche.lumino.controller.flash;

import android.content.Context;

import java.io.IOException;

/**
 * Interface for playing light scenes
 */
public interface IPlayingLightScene {

    /**
     * plays or stops light scene at host device
     * @param context for controlling flash
     * @throws IOException if converting scene in byte array failes  (for sending scene to client)
     */
    void toogleLightSceneHost(Context context) throws IOException;

    /**
     * plays or stops light scene at host device
     * @param message scene sended from host as byte array
     * @throws IOException if converting scene from byte array in scene class failes
     * @throws ClassNotFoundException if converting scene from byte array in scene class failes
     */
    void toogleLightSceneClient(byte[] message) throws IOException, ClassNotFoundException;

    /**
     * changes current scene TextView in host view
     * @param title from current scene
     */
    void setSceneTitleHost(String title);
}
