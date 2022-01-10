package de.carloausderwiesche.lumino.bluetooth;

import static android.content.ContentValues.TAG;

import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.*;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;

import de.carloausderwiesche.lumino.controller.flash.PlayingLightScene;

public class ServerAccept extends Thread {
    private final BluetoothServerSocket mmServerSocket;
    private static final String NAME = "BTApp";
    private final UUID MY_UUID = UUID.fromString("a61610ec-6e30-11ec-90d6-0242ac120003");
    private final BluetoothAdapter bluetoothAdapter;
    private BluetoothConnectionManager bluetoothConnectionManager;
    private final Handler handler;
    private PlayingLightScene playingLightScene;

    public ServerAccept(BluetoothAdapter bluetoothAdapter, Handler handler) {
        // Use a temporary object that is later assigned to mmServerSocket
        // because mmServerSocket is final.
        this.bluetoothAdapter = bluetoothAdapter;
        this.handler = handler;

        BluetoothServerSocket tmp = null;
        try {
            // MY_UUID is the app's UUID string, also used by the client code.
            tmp = bluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
        } catch (IOException e) {
            Log.e(TAG, "Socket's listen() method failed", e);
        }
        mmServerSocket = tmp;
    }

    public void run() {
        BluetoothSocket socket = null;
        // Keep listening until exception occurs or a socket is returned.
        while (socket == null) {
            try {
                Message message = Message.obtain();
                message.what = STATE_CONNECTING;
                handler.sendMessage(message);

                socket = mmServerSocket.accept();
            } catch (IOException e) {
                Log.e(TAG, "Socket's accept() method failed", e);
                Message message = Message.obtain();
                message.what = STATE_CONNECTION_FAILED;
                handler.sendMessage(message);
                break;
            }

            if (socket != null) {
                Message message = Message.obtain();
                message.what = STATE_CONNECTED;
                handler.sendMessage(message);

                bluetoothConnectionManager = new BluetoothConnectionManager(socket, handler);
                playingLightScene = PlayingLightScene.getPlayingLightScene();
                playingLightScene.setBCM(bluetoothConnectionManager);
                bluetoothConnectionManager.start();

                break;
            }
        }
    }

    // Closes the connect socket and causes the thread to finish.
    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Could not close the connect socket", e);
        }
    }
}