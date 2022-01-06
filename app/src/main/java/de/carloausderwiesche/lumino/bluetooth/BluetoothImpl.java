package de.carloausderwiesche.lumino.bluetooth;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import de.carloausderwiesche.lumino.MainActivity;

public class BluetoothImpl implements IBluetooth {
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 1;
    private static BluetoothImpl singleton = null;
    private BluetoothAdapter btAdapter;

    private BluetoothImpl() {
        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public static BluetoothImpl getBluetoothComponent() {
        if (BluetoothImpl.singleton == null) {
            BluetoothImpl.singleton = new BluetoothImpl();
        }
        return BluetoothImpl.singleton;
    }

    @Override
    public void enableBluetooth(Activity activity) {
        if (!btAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(activity, enableBtIntent, REQUEST_ENABLE_BT, Bundle.EMPTY);
        }
    }
}
