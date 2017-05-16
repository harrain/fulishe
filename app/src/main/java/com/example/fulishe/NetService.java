package com.example.fulishe;/**
 * Created by stephen on 2017/5/16.
 */

import com.example.fulishe.bean.NewGoodsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 包名： com.example.fulishe
 * 类名:  NetService
 * 类功能：
 * 创建者：  stephen
 * 创建日期: 2017/5/16
 */
public interface NetService {

    @GET("findNewAndBoutiqueGoods")
    Call<NewGoodsBean> getGoods(@Query("cat_id") int cat_id,@Query("page_id") int page_id,@Query("page_size") int page_size);
}
