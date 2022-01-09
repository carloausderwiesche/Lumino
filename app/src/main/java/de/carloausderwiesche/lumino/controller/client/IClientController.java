package de.carloausderwiesche.lumino.controller.client;

/**
 * Interface for Clientcontroller
 */
public interface IClientController {
    /**
     * client joins host session
     */
    void joinSession();

    /**
     * client determine if ready or not
     * @param status true => ready, false => not ready
     */
    void setStatus(boolean status);

    /**
     * client leaves session
     */
    void leaveSession();
}
