package com.hongyan.wdcf.business.asynctask;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

public class AsyncTaskTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new AsyncTaskView(this));
    }
}
