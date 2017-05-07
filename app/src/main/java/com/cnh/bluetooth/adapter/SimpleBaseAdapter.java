package com.cnh.bluetooth.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/4.
 * GitHub:https://github.com/CNHTT
 */

public abstract class SimpleBaseAdapter<T> extends BaseAdapter {

    private Context c = null;

    private LayoutInflater layoutInflater = null;

    private List<T> datas = null;

    public SimpleBaseAdapter(Context c, List<T> datas) {
        this.c = c;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(c);
    }


    /**
     * 刷新适配器
     * @param datas
     */
    public void refreshDatas(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        return datas!= null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas!=null ? datas.get(position) :null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * 显示数据
     * @param position
     * @param convertView
     * @param parent
     * @return convertView
     */
    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
