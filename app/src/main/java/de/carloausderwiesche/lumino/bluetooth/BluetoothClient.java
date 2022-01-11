package de.carloausderwiesche.lumino.bluetooth;


import static androidx.core.app.ActivityCompat.startActivityForResult;

import static de.carloausderwiesche.lumino.bluetooth.BluetoothStates.*;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Set;

import de.carloausderwiesche.lumino.R;

public class BluetoothClient implements IBluetoothClient{
    private static BluetoothClient singleton = null;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice[] queriedBluetoothDevices;
    private ListView listViewDevices;
    private TextView textStatus;
    private BluetoothHandler bluetoothHandler;
    private ClientConnect clientConnect;

    private BluetoothClient(ListView listView, TextView textView, Activity activity) {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        listViewDevices = listView;
        textStatus = textView;
        bluetoothHandler = BluetoothHandler.getBluetoothHandlerComponent(activity);
    }

    public static BluetoothClient getBluetoothClientComponent(ListView listView, TextView textView, Activity activity) {
        if (BluetoothClient.singleton == null) {
            BluetoothClient.singleton = new BluetoothClient(listView, textView, activity);
        }
        return BluetoothClient.singleton;
    }

    public static BluetoothClient getSingleton(){
        return singleton;
    }

    public void startBluetooth(Activity activity){
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(activity, enableBtIntent, REQUEST_ENABLE_BT, Bundle.EMPTY);
        }
    }

    public void listDevices(Context context){
        Set<BluetoothDevice> bt = bluetoothAdapter.getBondedDevices();
        String[] deviceNameArray = new String[bt.size()];
        queriedBluetoothDevices = new BluetoothDevice[bt.size()];
        int index = 0;

        if (bt.size() > 0) {
            for (BluetoothDevice device : bt) {
                queriedBluetoothDevices[index] = device;
                deviceNameArray[index] = device.getName();
                index++;
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, R.layout.bluetooth_row, deviceNameArray);
            listViewDevices.setAdapter(arrayAdapter);
        }
    }

    public boolean joinSession(int position){
        clientConnect = new ClientConnect(queriedBluetoothDevices[position], bluetoothAdapter, bluetoothHandler.getHandler());
        clientConnect.start();
        return true;
    }

    @Override
    public void leaveSession() {
        if (clientConnect != null) clientConnect.cancel();
    }


}
