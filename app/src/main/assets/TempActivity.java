package com.hongyan.wdcf.business.main;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

public class TempActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TempView(this));
    }
}