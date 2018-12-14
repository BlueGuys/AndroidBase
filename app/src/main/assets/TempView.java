package com.hongyan.wdcf.business.main;

import android.content.Context;

import com.hongyan.base.ActivityView;
import com.hongyan.wdcf.R;

public class TempView extends ActivityView {

    public TempView(Context context) {
        super(context);
        addBusinessView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        if (rootView == null) {
            return;
        }
    }
}