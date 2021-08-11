package com.example.mvp_lib.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp_lib.presenter.IPresenter;

/**
 * @ClassName BaseActivity
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/11 14:04
 * @Version 1.0
 */
public abstract class BaseActivity <P extends IPresenter> extends AppCompatActivity implements IActivity,IView{
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        hideView();
        hideData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.Destory();
            mPresenter=null;
        }
    }
}
