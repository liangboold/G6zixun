package com.example.g6information.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

/**
 * @ClassName GlideUtils
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 13:50
 * @Version 1.0
 */
public class GlideUtils {
    public static void getGlideim(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
    }
    public static void getGlideimyuanb(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).transform(new RoundedCorners(60)).into(imageView);
    }
    public static void getGlideimyuan(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).transform(new CircleCrop()).into(imageView);
    }
}
