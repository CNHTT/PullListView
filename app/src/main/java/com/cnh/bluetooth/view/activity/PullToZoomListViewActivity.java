package com.cnh.bluetooth.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.cnh.bluetooth.R;
import com.cnh.bluetooth.widget.PullToZoomListView;


public class PullToZoomListViewActivity extends AppCompatActivity {
    PullToZoomListView listView;
    private String[] adapterData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view);
        listView = (PullToZoomListView)findViewById(R.id.listview);
        adapterData = new String[] { "Activity","Service","Content Provider","Intent","BroadcastReceiver","ADT","Sqlite3","HttpClient","DDMS","Android Studio","Fragment","Loader" };

        listView.setAdapter(new ArrayAdapter<String>(PullToZoomListViewActivity.this,
                android.R.layout.simple_list_item_1, adapterData));
        listView.getHeaderView().setImageResource(R.mipmap.icon_bg2);
        listView.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
