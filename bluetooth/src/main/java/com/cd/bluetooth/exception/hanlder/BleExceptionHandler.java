package com.cd.bluetooth.exception.hanlder;

import com.cd.bluetooth.exception.BleException;
import com.cd.bluetooth.exception.ConnectException;
import com.cd.bluetooth.exception.GattException;
import com.cd.bluetooth.exception.InitiatedException;
import com.cd.bluetooth.exception.OtherException;
import com.cd.bluetooth.exception.TimeoutException;



/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */

public abstract class BleExceptionHandler {
    public BleExceptionHandler handleException(BleException exception) {
        if (exception != null) {
            if (exception instanceof ConnectException) {
                onConnectException((ConnectException) exception);
            } else if (exception instanceof GattException) {
                onGattException((GattException) exception);
            } else if (exception instanceof TimeoutException) {
                onTimeoutException((TimeoutException) exception);
            } else if (exception instanceof InitiatedException) {
                onInitiatedException((InitiatedException) exception);
            } else {
                onOtherException((OtherException) exception);
            }
        }
        return this;
    }

    /**
     * connect failed
     */
    protected abstract void onConnectException(ConnectException e);

    /**
     * gatt error status
     */
    protected abstract void onGattException(GattException e);

    /**
     * operation timeout
     */
    protected abstract void onTimeoutException(TimeoutException e);

    /**
     * operation inititiated error
     */
    protected abstract void onInitiatedException(InitiatedException e);

    /**
     * other exceptions
     */
    protected abstract void onOtherException(OtherException e);
}
