package com.cd.bluetooth.conn;

import android.bluetooth.BluetoothGattDescriptor;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */
public abstract class BleDescriptorCallback extends BleCallback {
    public abstract void onSuccess(BluetoothGattDescriptor descriptor);
}