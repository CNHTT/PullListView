package com.cnh.bluetooth.view.impl;

import android.content.Context;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/4.
 * GitHub:https://github.com/CNHTT
 */

public interface IUserLoginView extends  ICyBaseView {
    void onLoginSuccessNetWork();

    void onLoginFailed(String error);

    Context getContext();
}
