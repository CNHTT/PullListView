package com.cnh.bluetooth.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cnh.bluetooth.R;
import com.cnh.bluetooth.adapter.ItemTitlePagerAdapter;
import com.cnh.bluetooth.view.fragment.GoodsCommentFragment;
import com.cnh.bluetooth.view.fragment.GoodsDetailFragment;
import com.cnh.bluetooth.view.fragment.GoodsInfoFragment;
import com.cnh.bluetooth.widget.NoScrollViewPager;
import com.gxz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends AppCompatActivity {
    public PagerSlidingTabStrip psts_tabs;
    public NoScrollViewPager vp_content;
    public TextView tv_title;
    private List<Fragment> fragmentList = new ArrayList<>();
    private GoodsInfoFragment goodsInfoFragment;
    private GoodsDetailFragment goodsDetailFragment;
    private GoodsCommentFragment goodsCommentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        psts_tabs = (PagerSlidingTabStrip) findViewById(R.id.psts_tabs);
        vp_content  = (NoScrollViewPager) findViewById(R.id.vp_content);
        tv_title = (TextView) findViewById(R.id.tv_title);

        fragmentList.add(goodsInfoFragment = new GoodsInfoFragment());
        fragmentList.add(goodsDetailFragment = new GoodsDetailFragment());
        fragmentList.add(goodsCommentFragment  = new GoodsCommentFragment());
        vp_content.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),fragmentList,new String[]{"商品","详情","评价"}));

        vp_content.setOffscreenPageLimit(3);
        psts_tabs.setViewPager(vp_content);

    }
}
