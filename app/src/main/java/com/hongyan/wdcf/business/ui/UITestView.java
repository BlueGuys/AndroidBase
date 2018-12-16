package com.hongyan.wdcf.business.ui;

import android.content.Context;

import com.hongyan.base.ActivityView;
import com.hongyan.wdcf.R;

public class UITestView extends ActivityView {

    public UITestView(Context context) {
        super(context);
        addBusinessView(R.layout.activity_uitest);
        initView();
    }

    protected void initView() {
        if (rootView == null) {
            return;
        }
    }
}