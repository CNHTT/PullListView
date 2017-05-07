package com.cnh.bluetooth.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cnh.bluetooth.inter.Pullable;


/**
 * Created by Administrator on 2017/4/7.
 */

public class PullLinearLayout extends LinearLayout implements Pullable {
    public PullLinearLayout(Context context) {
        super(context);
    }

    public PullLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean canPullDown() {
        return true;
    }

    @Override
    public boolean canPullUp() {
        return true;
    }
}
