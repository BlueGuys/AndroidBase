package com.hongyan.wdcf.business.mp3;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

public class Mp3TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Mp3TestHolder(this).getLayoutId());
    }
}
