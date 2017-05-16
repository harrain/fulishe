package com.example.fulishe.adapter;/**
 * Created by stephen on 2017/5/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fulishe.R;
import com.example.fulishe.bean.NewGoodsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 包名： com.example.fulishe.adapter
 * 类名:  NewGoodsAdapter
 * 类功能：
 * 创建者：  stephen
 * 创建日期: 2017/5/16
 */
public class NewGoodsAdapter extends RecyclerView.Adapter<NewGoodsAdapter.NewGoodsHolder> {

    private Context mContext;
    private List<NewGoodsBean> goods;

    public NewGoodsAdapter(Context mContext, List<NewGoodsBean> goods) {
        this.mContext = mContext;
        this.goods = goods;
    }

    @Override
    public NewGoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.new_goods_item,parent,false);

        return new NewGoodsHolder(mContext,view,goods);
    }

    @Override
    public void onBindViewHolder(NewGoodsHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return goods == null ? 0 : goods.size();
    }

    static class NewGoodsHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.good_iv)
        ImageView goodIv;
        @BindView(R.id.price_tv)
        TextView priceTv;

        List<NewGoodsBean> goods;
        Context context;
        public NewGoodsHolder(Context context,View view,List<NewGoodsBean> list){
            super(view);
            ButterKnife.bind(view);
            goods = list;
            this.context = context;

        }

        public void bind(int position) {
            priceTv.setText("￥"+goods.get(position).getCurrencyPrice()+"");
            Glide.with(context).load(goods.get(position).getColorUrl()).into(goodIv);
        }
    }
}
