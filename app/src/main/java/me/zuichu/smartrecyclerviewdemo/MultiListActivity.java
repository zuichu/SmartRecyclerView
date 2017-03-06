package me.zuichu.smartrecyclerviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import me.zuichu.recyclerview.adapter.BaseMultiSmartAdapter;
import me.zuichu.recyclerview.view.ProgressStyle;
import me.zuichu.recyclerview.view.SmartRecyclerview;
import me.zuichu.smartrecyclerviewdemo.adapter.MultiAdapter;
import me.zuichu.smartrecyclerviewdemo.entity.MultiItem;

public class MultiListActivity extends AppCompatActivity implements SmartRecyclerview.LoadingListener, BaseMultiSmartAdapter.OnRecyclerViewItemClickListener, BaseMultiSmartAdapter.OnRecyclerViewItemLongClickListener {
    private SmartRecyclerview recyclerview;
    private MultiAdapter multiAdapter;
    private ArrayList<MultiItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_list);
        initView();
    }

    private void initView() {
        recyclerview = (SmartRecyclerview) this.findViewById(R.id.recyclerView);
        recyclerview.setRefreshProgressStyle(ProgressStyle.BallBeat);
        recyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);
        recyclerview.setArrowImageView(R.mipmap.ic_pulltorefresh_arrow);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setLoadingListener(this);
        list = new ArrayList<MultiItem>();
        multiAdapter = new MultiAdapter(this, list);
        recyclerview.setAdapter(multiAdapter);
        multiAdapter.setOnItemClickListener(this);
        multiAdapter.setOnItemLongClickListener(this);
        recyclerview.refresh();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                list.clear();
                for (int i = 0; i < 20; i++) {
                    MultiItem multiItem = new MultiItem();
                    multiItem.setName("文字" + i);
                    if (i % 4 == 0) {
                        multiItem.setItemType(0);
                    } else {
                        multiItem.setItemType(1);
                    }
                    list.add(multiItem);
                }
                recyclerview.refreshComplete();
            }

        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    MultiItem multiItem = new MultiItem();
                    multiItem.setName("文字" + i);
                    if (i % 4 == 0) {
                        multiItem.setItemType(0);
                    } else {
                        multiItem.setItemType(1);
                    }
                    list.add(multiItem);
                }
                recyclerview.loadMoreComplete();
            }

        }, 1000);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "点击" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(this, "长按" + position, Toast.LENGTH_SHORT).show();
    }
}
