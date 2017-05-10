package com.cd.bluetooth.exception;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */

public class InitiatedException extends BleException {
    public InitiatedException() {
        super(ERROR_CODE_INITIAL, "Initiated Exception Occurred! ");
    }
}