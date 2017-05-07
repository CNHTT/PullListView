package com.cnh.bluetooth.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cnh.bluetooth.ConstantValue;
import com.cnh.bluetooth.MainActivity;
import com.cnh.bluetooth.R;
import com.cnh.bluetooth.utils.PreferenceUtils;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SplashActivity extends AppCompatActivity {

    private ImageView iVSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        initFindById();
        iVSplash.setEnabled(false);
        Subscription time = rx.Observable.timer(3000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        if (PreferenceUtils.getPrefBoolean(SplashActivity.this, ConstantValue.AUTOMAICLOGIN,false)){
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                        iVSplash.setEnabled(true);
                    }
                });
        
    }

    private void initFindById() {
        iVSplash = (ImageView) findViewById(R.id.iv_splash);
    }
}
