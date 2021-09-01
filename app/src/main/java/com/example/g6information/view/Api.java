package com.example.g6information.view;

import com.example.g6information.entily.Grilbean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @ClassName Api
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 14:55
 * @Version 1.0
 */
public interface Api {
    @GET("api/v2/data/category/Girl/type/Girl/page/1/count/100")
    Observable<Grilbean>gril();
}
