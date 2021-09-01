package com.example.g6information.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.g6information.R;
import com.example.g6information.adarpter.Fragmentadarpter;
import com.example.g6information.entily.DaoMaster;
import com.example.g6information.entily.DaoSession;
import com.example.g6information.fragment.CarFragment;
import com.example.g6information.fragment.MenuFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private SlidingTabLayout tab;
    public static DaoSession daoSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        List<Fragment> fragments = new ArrayList<>();
        List<String> list = new ArrayList<>();
        fragments.add(new MenuFragment());
        fragments.add(new CarFragment());
        list.add("菜单");
        list.add("购物车");
        Fragmentadarpter fragmentadarpter = new Fragmentadarpter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        vp.setAdapter(fragmentadarpter);
        tab.setViewPager(vp,list.toArray(new String[list.size()]));
        SQLiteDatabase us = new DaoMaster.DevOpenHelper(this, "us").getWritableDatabase();

        daoSession = new DaoMaster(us).newSession();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (SlidingTabLayout) findViewById(R.id.tab);
    }
}