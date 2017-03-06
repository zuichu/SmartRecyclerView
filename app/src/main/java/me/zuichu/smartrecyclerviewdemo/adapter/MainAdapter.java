package me.zuichu.smartrecyclerviewdemo.adapter;

import android.content.Context;

import me.zuichu.recyclerview.adapter.BaseSmartAdapter;
import me.zuichu.recyclerview.viewholder.SmarViewHolder;

import java.util.List;

/**
 * Created by office on 2017/3/4.
 */
public class MainAdapter extends BaseSmartAdapter<String> {

    public MainAdapter(Context context, List<String> lists) {
        super(context, me.zuichu.smartrecyclerviewdemo.R.layout.item_main, lists);
    }

    @Override
    public void bindData(SmarViewHolder holder, String s) {
        holder.setText(me.zuichu.smartrecyclerviewdemo.R.id.tv_text, s);
    }
}
