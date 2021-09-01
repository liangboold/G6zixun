package com.example.g6information.contract;

import com.example.g6information.entily.Grilbean;
import com.example.mvp_lib.model.IModel;
import com.example.mvp_lib.view.IView;

import io.reactivex.Observer;

/**
 * @ClassName GrilContrict
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 14:38
 * @Version 1.0
 */
public interface GrilContrict {
    interface grilModel extends IModel{
        void gril(Observer<Grilbean>observer);
    }

    interface grilView extends IView{
        void grilfeel(Grilbean grilbean);
    }
}
