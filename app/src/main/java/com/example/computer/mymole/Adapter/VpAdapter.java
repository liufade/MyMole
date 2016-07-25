package com.example.computer.mymole.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.computer.mymole.Base.BaseFragment;

import java.util.List;

/**
 * Created by computer on 2016/7/21.
 */
public class VpAdapter extends FragmentPagerAdapter {
    List<BaseFragment> fragments;
    public VpAdapter(FragmentManager fm,List<BaseFragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
