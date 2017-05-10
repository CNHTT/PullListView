package com.cd.bluetooth.scan;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;

import com.cd.bluetooth.data.ScanResult;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */

public abstract class MacScanCallback extends PeriodScanCallback{
    private String mMac;
    private AtomicBoolean hasFound = new AtomicBoolean(false);

    public MacScanCallback(String mac, long timeoutMillis) {
        super(timeoutMillis);
        this.mMac = mac;
        if (TextUtils.isEmpty(mac)) {
            onDeviceNotFound();
        }
    }

    @Override
    public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
        if (device == null)
            return;
        if (TextUtils.isEmpty(device.getAddress())) {
            return;
        }

        if (!hasFound.get()) {

            ScanResult scanResult = new ScanResult(device, rssi, scanRecord,
                    System.currentTimeMillis());

            if (mMac.equalsIgnoreCase(device.getAddress())) {
                hasFound.set(true);
                bleBluetooth.stopScan(MacScanCallback.this);
                onDeviceFound(scanResult);
            }
        }
    }

    @Override
    public void onScanTimeout() {
        onDeviceNotFound();
    }

    @Override
    public void onScanCancel() {

    }

    public abstract void onDeviceFound(ScanResult scanResult);

    public abstract void onDeviceNotFound();
}
