package com.hongyan.wdcf.business.device;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

public class DeviceTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DeviceTestHolder(this).getLayoutId());
    }

}
