package com.example.mvp_lib.presenter;

import com.example.mvp_lib.model.IModel;
import com.example.mvp_lib.view.IView;

/**
 * @ClassName BasePresenter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/11 14:08
 * @Version 1.0
 */
public class BasePresenter <M extends IModel,V extends IView> implements IPresenter{
    protected M mModel;
    protected V mView;

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void Destory() {
        if (mModel!=null){
            mModel.Destory();
            mModel=null;
        }
        if (mView!=null){
            mView=null;
        }
    }
}
