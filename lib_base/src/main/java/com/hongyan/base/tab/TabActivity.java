package com.hongyan.base.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/6/20.
 */

public class TabActivity extends BaseActivity {

    private TabViewHolder viewHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewHolder = new TabViewHolder(this);
        setContentView(viewHolder.getLayoutId());
        viewHolder.initView();
    }

    public void addSubPage(ArrayList<SubPage> list) {
        viewHolder.addSubPage(list);
    }

    protected void select(int position){

    }

    protected void selectPage(int position){
        viewHolder.selectPage(position);
    }

}
