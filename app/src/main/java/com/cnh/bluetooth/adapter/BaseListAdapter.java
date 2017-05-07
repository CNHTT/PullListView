package com.cnh.bluetooth.adapter;

import android.content.Context;
import android.os.Handler;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */

public class BaseListAdapter<T> extends ArrayAdapter<T> {
    protected Context mContext;
    protected Handler mHandler;
    protected List<T> mDataList;
    protected boolean hasNoData;

    public BaseListAdapter(Context context,List<T> mDataList){
        super(context,0,mDataList);
        this.mContext = context;
        this.mDataList = mDataList;
        if (this.mDataList.isEmpty()||this.mDataList==null){
            hasNoData = true;
        }
    }
    public BaseListAdapter(Context context,List<T> mDataList, Handler Handler){
        super(context,0,mDataList);
        this.mContext = context;
        this.mDataList = mDataList;
        this.mHandler = Handler;
        if (this.mDataList.isEmpty()||this.mDataList==null){
            hasNoData = true;
        }
    }

    public void updateListView(List<T> mDataList){
        this .mDataList = mDataList;
        hasNoData = (this.mDataList==null||this.mDataList.isEmpty());
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        if (hasNoData)
            return 1;
        return (mDataList ==null||mDataList.isEmpty())?0:mDataList.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (hasNoData)
            return 0;
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
