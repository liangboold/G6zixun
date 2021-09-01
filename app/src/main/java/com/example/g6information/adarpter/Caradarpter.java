package com.example.g6information.adarpter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.g6information.R;
import com.example.g6information.entily.Userentily;
import com.example.g6information.utils.GlideUtils;

import java.util.List;

/**
 * @ClassName Caradarpter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 16:19
 * @Version 1.0
 */
public class Caradarpter extends BaseQuickAdapter<Userentily, BaseViewHolder> {
    public Caradarpter(List<Userentily> data) {
        super(R.layout.citem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Userentily item) {
        GlideUtils.getGlideimyuanb(mContext,item.getUrl(),helper.getView(R.id.cim));
    }
}
