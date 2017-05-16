package com.example.fulishe;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fulishe.adapter.NewGoodsAdapter;
import com.example.fulishe.bean.NewGoodsBean;
import com.example.fulishe.util.RetrofitUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewGoodFragment extends Fragment {


    @BindView(R.id.goodrv)
    RecyclerView goodrv;
    @BindView(R.id.freshlayout)
    SwipeRefreshLayout freshlayout;
    Unbinder unbinder;

    NewGoodsAdapter goodsAdapter;
    public NewGoodFragment() {
        // Required empty public constructor
    }

    private  Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            goodsAdapter = new NewGoodsAdapter(getContext(), (List<NewGoodsBean>) msg.obj);
            goodrv.setAdapter(goodsAdapter);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_good, container, false);
        unbinder = ButterKnife.bind(this, view);
        loaddata();
        return view;

    }

    private void loaddata() {
        NetService netService = RetrofitUtil.build(NetService.class).create(NetService.class);
        Call<NewGoodsBean> goodsCall = netService.getGoods(0, 1, 10);
        goodsCall.enqueue(new Callback<NewGoodsBean>() {
            @Override
            public void onResponse(Call<NewGoodsBean> call, Response<NewGoodsBean> response) {
                NewGoodsBean goodsBean = response.body();
                Message msg = Message.obtain();
                msg.obj = msg;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<NewGoodsBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
