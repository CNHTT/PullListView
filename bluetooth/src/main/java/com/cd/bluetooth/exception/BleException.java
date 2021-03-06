package com.cd.bluetooth.exception;

import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */

public abstract class BleException implements Serializable {
    private static final long serialVersionUID = 8004414918500865564L;

    public static final int ERROR_CODE_TIMEOUT = 1;
    public static final int ERROR_CODE_INITIAL = 101;
    public static final int ERROR_CODE_GATT = 201;
    public static final int GATT_CODE_OTHER = 301;

    public static final TimeoutException TIMEOUT_EXCEPTION = new TimeoutException();

    private int code;
    private String description;

    public BleException(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public BleException setCode(int code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BleException setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "BleException { " +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
