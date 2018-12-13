package com.hongyan.wdcf.business.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hongyan.base.ActivityView;
import com.hongyan.base.BaseActivity;
import com.hongyan.wdcf.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainView(this));
    }
}
