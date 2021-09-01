package com.example.g6information.model;

import com.example.g6information.contract.GrilContrict;
import com.example.g6information.entily.Grilbean;
import com.example.g6information.utils.Utils;
import com.example.g6information.view.Api;
import com.example.mvp_lib.model.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName GrilModel
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 14:57
 * @Version 1.0
 */
public class GrilModel extends BaseModel implements GrilContrict.grilModel {
    @Override
    public void gril(Observer<Grilbean> observer) {
        Api api = new Utils().getUtils().aaa("https://gank.io/").create(Api.class);
        api.gril().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
