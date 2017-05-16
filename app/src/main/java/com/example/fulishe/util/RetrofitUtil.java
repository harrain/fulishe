package com.example.fulishe.util;/**
 * Created by stephen on 2017/5/16.
 */

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 包名： com.example.fulishe.util
 * 类名:  RetrofitUtil
 * 类功能：
 * 创建者：  stephen
 * 创建日期: 2017/5/16
 */
public class RetrofitUtil {

    public static Retrofit build(Class<?> z){
        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("http://101.251.196.90:8080/FuLiCenterServerV2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
