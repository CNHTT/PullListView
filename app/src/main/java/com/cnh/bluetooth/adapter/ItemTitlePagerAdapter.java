package com.cnh.bluetooth.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 详情页ViewPager的内容
 * Created by Administrator on 2017/3/3.
 */

public class ItemTitlePagerAdapter extends FragmentPagerAdapter {

    private String[] titleArray;
    private List<Fragment> fragmentList;

    public ItemTitlePagerAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] titleArray) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleArray=titleArray;
    }

    public void setTitleArray(String[] titleArray) {
        this.titleArray = titleArray;
        notifyDataSetChanged();
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titleArray[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }
}
