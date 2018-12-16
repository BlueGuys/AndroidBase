package com.hongyan.wdcf.business.ui;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

public class UITestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new UITestView(this));
    }
}