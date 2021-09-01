package com.example.g6information.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.g6information.R;
import com.example.g6information.activity.MainActivity;
import com.example.g6information.adarpter.Griladarpter;
import com.example.g6information.contract.GrilContrict;
import com.example.g6information.entily.Grilbean;
import com.example.g6information.entily.Userentily;
import com.example.g6information.model.GrilModel;
import com.example.g6information.presenter.GrilPresenter;
import com.example.mvp_lib.view.BaseFragment;
import com.example.mvp_lib.view.IFragment;


public class MenuFragment extends BaseFragment<GrilPresenter> implements IFragment, GrilContrict.grilView {
    RecyclerView recyclerView;
    Griladarpter griladarpter;
    @Override
    public void grilfeel(Grilbean grilbean) {
        griladarpter = new Griladarpter(grilbean.getData());
        Log.i("123", "grilfeel: "+grilbean.getData().toString());
        recyclerView.setAdapter(griladarpter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        griladarpter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Grilbean.DataBean item = (Grilbean.DataBean) adapter.getItem(position);
                String url = item.getUrl();
                Userentily userentily = new Userentily();
                userentily.setUrl(url);
                MainActivity.daoSession.insert(userentily);
                Toast.makeText(getActivity(), "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int bandLayout() {
        return R.layout.fragment_menu;
    }

    @Override
    public void hideView() {
        recyclerView = findViewById(R.id.rv);
    }

    @Override
    public void hideData() {
        mPresenter = new GrilPresenter(new GrilModel(),this);
        mPresenter.fff();
    }
}