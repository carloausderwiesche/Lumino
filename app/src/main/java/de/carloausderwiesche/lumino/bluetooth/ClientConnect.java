package de.carloausderwiesche.lumino.bluetooth;

import static android.content.ContentValues.TAG;

import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.*;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;

public class ClientConnect extends Thread{
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
    private final BluetoothAdapter bluetoothAdapter;
    private BluetoothConnectionManager bluetoothConnectionManager;
    private final Handler handler;

    private final UUID MY_UUID = UUID.fromString("a61610ec-6e30-11ec-90d6-0242ac120003");

    public ClientConnect(BluetoothDevice device, BluetoothAdapter bluetoothAdapter, Handler handler) {
        // Use a temporary object that is later assigned to mmSocket
        // because mmSocket is final.
        BluetoothSocket tmp = null;
        mmDevice = device;
        this.bluetoothAdapter = bluetoothAdapter;
        this.handler = handler;

        try {
            // Get a BluetoothSocket to connect with the given BluetoothDevice.
            // MY_UUID is the app's UUID string, also used in the server code.
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) {
            Log.e(TAG, "Socket's create() method failed", e);
        }
        mmSocket = tmp;
    }

    public void run() {
        // Cancel discovery because it otherwise slows down the connection.
        bluetoothAdapter.cancelDiscovery();

        try {
            mmSocket.connect();
            Message message = Message.obtain();
            message.what = STATE_CONNECTED;
            handler.sendMessage(message);

            bluetoothConnectionManager = new BluetoothConnectionManager(mmSocket, handler);
            bluetoothConnectionManager.start();

        } catch (IOException connectException) {
            connectException.printStackTrace();
            Message message = Message.obtain();
            message.what = STATE_CONNECTION_FAILED;
            handler.sendMessage(message);
        }

        //String messageFromClient = "Hello from Client";
        //bluetoothConnectionManager.write(messageFromClient.getBytes());
        // The connection attempt succeeded. Perform work associated with
        // the connection in a separate thread.
    }

    // Closes the client socket and causes the thread to finish.
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Could not close the client socket", e);
        }
    }


}

