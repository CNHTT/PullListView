package com.cd.bluetooth.data;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/10.
 * GitHub:https://github.com/CNHTT
 */

public class ScanResult implements Parcelable {

    private BluetoothDevice mDevice;
    private byte[] mScanRecord;

    private int mRssi;

    private long mTimestampNanos;

    public ScanResult(BluetoothDevice mDevice, int mRssi,byte[] mScanRecord,  long mTimestampNanos) {
        this.mDevice = mDevice;
        this.mScanRecord = mScanRecord;
        this.mRssi = mRssi;
        this.mTimestampNanos = mTimestampNanos;
    }

    protected ScanResult(Parcel in) {
        mDevice  = in.readParcelable(BluetoothDevice.class.getClassLoader());
        mScanRecord = in.createByteArray();
        mRssi = in.readInt();
        mTimestampNanos =in.readLong();
    }

    public static final Creator<ScanResult> CREATOR = new Creator<ScanResult>() {
        @Override
        public ScanResult createFromParcel(Parcel in) {
            return new ScanResult(in);
        }

        @Override
        public ScanResult[] newArray(int size) {
            return new ScanResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mDevice,flags);
        dest.writeByteArray(mScanRecord);
        dest.writeInt(mRssi);
        dest.writeLong(mTimestampNanos);
    }

    public BluetoothDevice getDevice() {
        return mDevice;
    }

    public void setDevice(BluetoothDevice mDevice) {
        this.mDevice = mDevice;
    }

    public byte[] getScanRecord() {
        return mScanRecord;
    }

    public void setScanRecord(byte[] mScanRecord) {
        this.mScanRecord = mScanRecord;
    }

    public int getRssi() {
        return mRssi;
    }

    public void setRssi(int mRssi) {
        this.mRssi = mRssi;
    }

    public long getTimestampNanos() {
        return mTimestampNanos;
    }

    public void setTimestampNanos(long mTimestampNanos) {
        this.mTimestampNanos = mTimestampNanos;
    }
}
