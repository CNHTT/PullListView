package com.cnh.bluetooth.view.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cnh.bluetooth.R;
import com.cnh.bluetooth.utils.AudioRecoderUtils;
import com.cnh.bluetooth.utils.PopupWindowFactory;
import com.cnh.bluetooth.utils.TimeUtils;

public class RecordActivity extends AppCompatActivity {


    static  final int VOICE_REQUEST_CODE=66;
    private Button mButton;

    private ImageView  mImageView;


    private TextView mTextView;

    private AudioRecoderUtils audioRecoderUtils;

    private Context context;

    private PopupWindowFactory mPop;

    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);


        context =this;

        rl = (RelativeLayout) findViewById(R.id.activity_record);

        mButton = (Button) findViewById(R.id.record);
      //PopupWindow的布局文件
        final View view = View.inflate(this, R.layout.layout_microphone, null);

        mPop = new PopupWindowFactory(this,view);

        mImageView = (ImageView) view.findViewById(R.id.iv_recording_icon);

        mTextView = (TextView) view.findViewById(R.id.tv_recording_time);


        //可传入文件保存地址
        audioRecoderUtils =  new AudioRecoderUtils(Environment.getExternalStorageDirectory()+"/cnh/");


        //录音回调
        audioRecoderUtils.setOnAudioStatusUpdateListener(new AudioRecoderUtils.OnAudioStatusUpdateListener() {
            @Override
            public void onUpdate(double db, long time) {
                mImageView.getDrawable().setLevel((int) (3000+6000*db/100));
                mTextView.setText(TimeUtils.long2String(time));
            }

            @Override
            public void onStop(String filh) {
                Log.d(getLocalClassName(),filh);
                mTextView.setText(TimeUtils.long2String(0));
                Toast.makeText(context,"保存成功-"+filh,Toast.LENGTH_SHORT)
                        .show();
            }
        });


        requestPermissions();


    }

    /**
     * 开始判断有没有权限
     */
    private void requestPermissions() {
        //判断权限
        if (
                ContextCompat.checkSelfPermission(context,Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                        PackageManager.PERMISSION_GRANTED&&
                ContextCompat.checkSelfPermission(context,Manifest.permission.RECORD_AUDIO)==
                        PackageManager.PERMISSION_GRANTED){
            startListener();

        }else {

            ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO},VOICE_REQUEST_CODE);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == VOICE_REQUEST_CODE){

            if ((grantResults[0] == PackageManager.PERMISSION_GRANTED)&&
                    (grantResults[1] == PackageManager.PERMISSION_GRANTED))
            {
                startListener();
            }else {
                Toast.makeText(context,"权限获取失败",Toast.LENGTH_SHORT)
                        .show();
            }

        }

    }

    private void startListener() {
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    //开始录音
                    case  MotionEvent.ACTION_DOWN:
                        mPop.showAtLocation(rl, Gravity.CENTER,0,0);

                        mButton.setText("松开保存");
                        audioRecoderUtils.startRecord();

                        break;
                    case MotionEvent.ACTION_UP:
                        audioRecoderUtils.stopRecord();    //结束录音

//                        audioRecoderUtils.cancelRecord();

                        mPop.dismiss();

                        mButton.setText("按住说话");

                        break;
                }

                return true;
            }
        });
    }
}
