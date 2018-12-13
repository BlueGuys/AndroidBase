package com.hongyan.wdcf.business.textview;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

/**
 * https://www.cnblogs.com/gaozy/p/3994878.html
 */

public class TextViewTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TextViewTestHolder(this).getLayoutId());
    }
}
