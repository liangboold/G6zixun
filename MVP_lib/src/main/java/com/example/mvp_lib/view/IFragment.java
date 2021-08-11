package com.example.mvp_lib.view;


import android.view.View;

import androidx.annotation.IdRes;

/**
 * @ClassName IFragment
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/11 14:02
 * @Version 1.0
 */
public interface IFragment extends IActivity{
    <T extends View> T findViewById(@IdRes int id);
}
