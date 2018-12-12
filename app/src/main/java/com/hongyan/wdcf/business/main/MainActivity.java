package com.hongyan.wdcf.business.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hongyan.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private MainViewHolder mainViewHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewHolder = new MainViewHolder(this);
        setContentView(mainViewHolder.getLayoutId());
    }

}
