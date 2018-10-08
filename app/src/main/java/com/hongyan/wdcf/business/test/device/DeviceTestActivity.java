package com.hongyan.wdcf.business.test.device;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class DeviceTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new DeviceTestHolder(this);
    }

}
