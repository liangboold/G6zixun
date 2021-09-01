package com.example.g6information.adarpter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.g6information.R;
import com.example.g6information.entily.Grilbean;
import com.example.g6information.utils.GlideUtils;

import java.util.List;

/**
 * @ClassName Griladarpter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 15:01
 * @Version 1.0
 */
public class Griladarpter extends BaseQuickAdapter<Grilbean.DataBean, BaseViewHolder> {
    public Griladarpter(List<Grilbean.DataBean> data) {
        super(R.layout.mitem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Grilbean.DataBean item) {
        helper.setText(R.id.tv,item.getDesc());
        GlideUtils.getGlideim(mContext,item.getUrl(),helper.getView(R.id.im));
    }
}
