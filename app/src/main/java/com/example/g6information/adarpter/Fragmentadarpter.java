package com.example.g6information.adarpter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @ClassName Fragmentadarpter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 11:18
 * @Version 1.0
 */
public class Fragmentadarpter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    public Fragmentadarpter(FragmentManager fm, int behavior,List<Fragment> fragments) {
        super(fm, behavior);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        super.destroyItem(container, position, object);
    }
}
