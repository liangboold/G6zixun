package com.example.g6information.presenter;

import com.example.g6information.contract.GrilContrict;
import com.example.g6information.entily.Grilbean;
import com.example.mvp_lib.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @ClassName GrilPresenter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 14:59
 * @Version 1.0
 */
public class GrilPresenter extends BasePresenter<GrilContrict.grilModel,GrilContrict.grilView> {
    public GrilPresenter(GrilContrict.grilModel mModel, GrilContrict.grilView mView) {
        super(mModel, mView);
    }
    public void fff(){
        mModel.gril(new Observer<Grilbean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Grilbean grilbean) {
                mView.grilfeel(grilbean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
