package com.hongyan.wdcf.business.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hongyan.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainView(this));
    }
}
