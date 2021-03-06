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

public abstract class NameScanCallback extends PeriodScanCallback {

    private String mName = null;

    private  String[] mNames = null;

    private boolean  mFuzzy = false;

    private AtomicBoolean hasFound = new AtomicBoolean(false);

    public NameScanCallback(String name, long timeoutMillis, boolean fuzzy) {
        super(timeoutMillis);
        this.mName = name;
        this.mFuzzy = fuzzy;
        if (TextUtils.isEmpty(name)) {
            onDeviceNotFound();
        }
    }
    public NameScanCallback(String[] names, long timeoutMillis, boolean fuzzy) {
        super(timeoutMillis);
        this.mNames = names;
        this.mFuzzy = fuzzy;
        if (names == null || names.length<1) {
            onDeviceNotFound();
        }
    }

    protected abstract void onDeviceNotFound();


    @Override
    public void onScanTimeout() {
        onDeviceNotFound();
    }

    @Override
    public void onScanCancel() {

    }

    @Override
    public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            if (device==null)
                return;

        if (TextUtils.isEmpty(device.getName()))
            return;

        if (!hasFound.get()){
            ScanResult scanResult = new ScanResult(device ,rssi,scanRecord,System.currentTimeMillis());

            if (mName != null)
            {
                if (mFuzzy? device.getName().contains(mName):mName.equalsIgnoreCase(device.getName())){
                    hasFound.set(true);
                    bleBluetooth.stopScan(NameScanCallback.this);
                    onDeviceFound(scanResult);
                }
            }else if (mNames != null){
                for (String name : mNames) {
                    if (mFuzzy ? device.getName().contains(name) : name.equalsIgnoreCase(device.getName())) {
                        hasFound.set(true);
                        bleBluetooth.stopScan(NameScanCallback.this);
                        onDeviceFound(scanResult);
                        return;
                    }
                }

            }

        }
    }

    protected abstract void onDeviceFound(ScanResult scanResult);
}
