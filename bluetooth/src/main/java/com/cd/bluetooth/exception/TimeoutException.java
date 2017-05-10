package com.cd.bluetooth.exception;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */

public class TimeoutException extends BleException {
    public TimeoutException(int code, String description) {
        super(ERROR_CODE_TIMEOUT, "Timeout Exception Occurred! ");
    }
}
