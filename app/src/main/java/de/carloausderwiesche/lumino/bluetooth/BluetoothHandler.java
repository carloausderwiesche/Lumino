package de.carloausderwiesche.lumino.bluetooth;

import static android.content.ContentValues.TAG;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_CONNECTED;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_CONNECTING;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_CONNECTION_FAILED;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_LISTENING;
import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.STATE_MESSAGE_RECEIVED;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


public class BluetoothHandler {
    private static BluetoothHandler singleton = null;
    private Handler handler;


    private BluetoothHandler(Activity activity) {
        handler = new Handler(msg -> {

            switch (msg.what) {
                case STATE_LISTENING:
                    //txtStatus.setText("Listening");
                    //bluetoothClient.setStatus("Listening");
                    Toast.makeText(activity.getApplicationContext(), "Listening", Toast.LENGTH_SHORT);
                    Log.e(TAG, "Listening");
                    break;
                case STATE_CONNECTING:
                    Toast.makeText(activity.getApplicationContext(), "Connecting", Toast.LENGTH_SHORT);
                    Log.e(TAG, "Connecting");
                    break;
                case STATE_CONNECTED:
                    Toast.makeText(activity.getApplicationContext(), "Connected", Toast.LENGTH_SHORT);

                    Log.e(TAG, "Connected");
                    break;
                case STATE_CONNECTION_FAILED:
                    Log.e(TAG, "Connection failed");
                    Toast.makeText(activity.getApplicationContext(), "Connection failed", Toast.LENGTH_SHORT);
                    break;
                case STATE_MESSAGE_RECEIVED:
                    byte[] readBuff = (byte[]) msg.obj;
                    String tempMsg = new String(readBuff, 0, msg.arg1);
                    //txt_message.setText(tempMsg);
                    //messageReceived(tempMsg);
                    Log.e(TAG,"Message received" + tempMsg);
//                    Toast.makeText(txtStatus.getContext(), "Message received: " + tempMsg, Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
    }

    public static BluetoothHandler getBluetoothHandlerComponent(Activity activity){
        if (singleton == null){
            singleton = new BluetoothHandler(activity);
        }
        return singleton;
    }

    public Handler getHandler(){
        return handler;
    }


}
