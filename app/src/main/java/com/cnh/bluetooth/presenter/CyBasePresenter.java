package com.cnh.bluetooth.presenter;

import com.cnh.bluetooth.view.impl.ICyBaseView;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/4.
 * GitHub:https://github.com/CNHTT
 */

public class CyBasePresenter <T extends ICyBaseView> {
    private  T mView;
    public void attach(T mView){
        this.mView = mView;
    }

    public  void detachView(){
        if (mView != null)
            mView = null;
    }
}
