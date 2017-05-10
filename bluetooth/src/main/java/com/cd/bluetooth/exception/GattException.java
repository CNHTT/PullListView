package com.cd.bluetooth.exception;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */

public class GattException extends BleException {
    private int gattStatus;

    public GattException(int gattStatus) {
        super(ERROR_CODE_GATT, "Gatt Exception Occurred! ");
        this.gattStatus = gattStatus;
    }


    public int getGattStatus() {
        return gattStatus;
    }

    public GattException setGattStatus(int gattStatus) {
        this.gattStatus = gattStatus;
        return this;
    }

    @Override
    public String toString() {
        return "GattException{" +
                "gattStatus=" + gattStatus +
                "} " + super.toString();
    }
}
