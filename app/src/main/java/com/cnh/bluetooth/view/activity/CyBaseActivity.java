package com.cnh.bluetooth.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.cnh.bluetooth.R;
import com.cnh.bluetooth.inter.ICyBase;
import com.cnh.bluetooth.presenter.CyBasePresenter;
import com.cnh.bluetooth.utils.AppManager;
import com.cnh.bluetooth.utils.ContextUtils;
import com.cnh.bluetooth.utils.SystemBarTintManager;
import com.cnh.bluetooth.utils.Utils;
import com.cnh.bluetooth.view.impl.ICyBaseView;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/4.
 * GitHub:https://github.com/CNHTT
 */

public abstract class CyBaseActivity<T extends CyBasePresenter<ICyBaseView>> extends AppCompatActivity implements ICyBase {


    /**
     * 主线程
     */
    private  long mUiThreadId;

    public  void setActionBar(){

    }

    public  void getIntentValue(){
    }

    /**
     * 打印
     * @param log
     */
    public void printLog(String log){
        Log.d(getLocalClassName(),log);
    }

    @Override
    protected void onResume() {
        super.onResume();
        printLog("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printLog("onPause");
    }

    protected  boolean isSetStatusBar(){
        return false;
    }

    protected  CyBasePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUiThreadId = Process.myTid();
        AppManager.getAppManager().addActivity(this);
        mPresenter = getPresenter();
        if (mPresenter != null && this instanceof  ICyBaseView)
            mPresenter.attach((ICyBaseView) this);
        initWindow();
        getIntentValue();
        mRootView = createView(null,null,savedInstanceState);
        setContentView(mRootView);
        if (getToolBarId()!=0){
            mToolbar = (Toolbar) findViewById(getToolBarId());
            setSupportActionBar(mToolbar);
            setActionBar();
        }
        initFindById();
        bindView(savedInstanceState);

    }
    protected abstract void initFindById();

    protected abstract int getToolBarId();


    private SystemBarTintManager tintManager;
    private void initWindow() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT   && isSetStatusBar()){

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorAccent);
        }
    }


    protected void setStatusBarTintRes(int color) {
        if (tintManager != null) {
            tintManager.setStatusBarTintResource(color);
        }
    }
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = ContextUtils.inflate(this, getContentLayout());
        Utils.hideKeyboard(view, this);
        return view;
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public View getView() {
        return mRootView;
    }

    @Override
    public int getContentLayout() {
        return 0;
    }
    private Toolbar mToolbar;
    protected View mRootView;


    @Override
    protected void onNewIntent(Intent intent) {
        mUiThreadId = Process.myTid();
        super.onNewIntent(intent);
    }

    /**
     * 获取UI线程ID
     *
     * @return UI线程ID
     */
    public long getUIThreadId() {
        return mUiThreadId;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);
        if (mPresenter != null && this instanceof ICyBaseView) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }
}
