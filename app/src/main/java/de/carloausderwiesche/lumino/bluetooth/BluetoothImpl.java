package de.carloausderwiesche.lumino.bluetooth;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.*;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class BluetoothImpl {
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 1;
    private static BluetoothImpl singleton = null;
    private BluetoothAdapter btAdapter;
    private TextView txtStatus;

    private BluetoothDevice[] queriedBluetoothDevices;

    private BluetoothImpl() {
        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public static BluetoothImpl getBluetoothComponent() {
        if (BluetoothImpl.singleton == null) {
            BluetoothImpl.singleton = new BluetoothImpl();
        }
        return BluetoothImpl.singleton;
    }

    public void setStatusTextView(TextView status){
        this.txtStatus = status;
    }



    private void messageReceived(String msg) {
        Log.e("BLUETOOTH", "messageReceived Method invoked");
    }



    public void enableBluetooth(Activity activity) {
        if (!btAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(activity, enableBtIntent, REQUEST_ENABLE_BT, Bundle.EMPTY);
        }
    }

    public void startBluetoothCLient(Activity activity, ListView listViewBTDevices){
        //Bluetooth aktivieren
        enableBluetooth(activity);
        //liste mit gefundenen geräten anzeigen
        displayBLuetoothDevices();
        // wenn eins angeklickt wird -> verbinden
    }

    public void displayBLuetoothDevices(){

    }

}


