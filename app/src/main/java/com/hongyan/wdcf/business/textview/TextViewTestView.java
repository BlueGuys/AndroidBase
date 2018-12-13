package com.hongyan.wdcf.business.textview;

import android.content.Context;
import android.view.View;

import com.hongyan.base.ActivityView;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.ItemA;

public class TextViewTestView extends ActivityView {

    public TextViewTestView(Context context) {
        super(context);
        addBusinessView(R.layout.activity_test_textview);
        initView();
    }

    protected void initView() {

    }

}
