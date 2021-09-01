package com.example.g6information.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 14:47
 * @Version 1.0
 */
public class Utils {
    public Utils() {
    }
    private static Utils utils = new Utils();

    public Utils getUtils() {
        return utils;
    }

    public Retrofit aaa(String url){
        Retrofit build = new Retrofit.Builder().client(
                new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        )
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return build;
    }
}
