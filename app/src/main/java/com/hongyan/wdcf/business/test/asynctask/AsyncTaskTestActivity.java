package com.hongyan.wdcf.business.test.asynctask;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.business.account.core.MainMessageEvent;

import org.greenrobot.eventbus.EventBus;

public class AsyncTaskTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new AsyncTaskTestHolder(this);
    }

}
