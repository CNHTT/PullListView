package com.cd.bluetooth.conn;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;

import com.cd.bluetooth.data.ScanResult;
import com.cd.bluetooth.exception.BleException;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */
public abstract class BleGattCallback extends BluetoothGattCallback {

    public abstract void onNotFoundDevice();

    public abstract void onFoundDevice(ScanResult scanResult);

    public abstract void onConnectSuccess(BluetoothGatt gatt, int status);

    public abstract void onConnectFailure(BleException exception);

}
