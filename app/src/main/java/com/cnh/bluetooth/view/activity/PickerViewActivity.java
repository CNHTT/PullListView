package com.cnh.bluetooth.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cnh.bluetooth.R;
import com.cnh.bluetooth.widget.PickerView;

import java.util.ArrayList;
import java.util.List;

public class PickerViewActivity extends AppCompatActivity {
    PickerView pickerView;
    PickerView pickerView1;
    PickerView pickerView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_view);

        pickerView  = (PickerView) findViewById(R.id.pickerview);
        pickerView1= (PickerView) findViewById(R.id.pickerview1);
        pickerView2  = (PickerView) findViewById(R.id.pickerview2);
        List<String> data = new ArrayList<String>();
        List<String> seconds = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            data.add("0" + i);
        }
        for (int i = 0; i < 60; i++)
        {
            seconds.add(i < 10 ? "0" + i : "" + i);
        }
        pickerView.setData(data);
        pickerView.setOnSelectListener(new PickerView.onSelectListener()
        {

            @Override
            public void onSelect(String text)
            {
                Toast.makeText(PickerViewActivity.this, "选择了 " + text + " 分",
                        Toast.LENGTH_SHORT).show();
            }
        });
        pickerView1.setData(seconds);
        pickerView1.setOnSelectListener(new PickerView.onSelectListener()
        {

            @Override
            public void onSelect(String text)
            {
                Toast.makeText(PickerViewActivity.this, "选择了 " + text + " 秒",
                        Toast.LENGTH_SHORT).show();
            }
        });

        List<String> a = new ArrayList<>();
        a.add("---");
        pickerView2.setData(a);
//        pickerView2.setOnSelectListener(new PickerView.onSelectListener()
//        {
//
//            @Override
//            public void onSelect(String text)
//            {
//                Toast.makeText(PickerViewActivity.this, "选择了 " + text + " 秒",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
        pickerView.setSelected(0);
//        pickerView1.setSelected(0);
//        pickerView2.setSelected(0);
    }

}
