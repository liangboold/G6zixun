package com.example.mvp_lib.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvp_lib.presenter.IPresenter;

/**
 * @ClassName BaseFragment
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/11 14:05
 * @Version 1.0
 */
public abstract class BaseFragment <P extends IPresenter> extends Fragment implements IFragment,IView {
    protected P mPresenter;
    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return view = inflater.inflate(bandLayout(),container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideView();
        hideData();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return view.findViewById(id);
    }
}
