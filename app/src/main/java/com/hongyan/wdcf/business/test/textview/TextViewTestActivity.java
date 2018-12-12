package com.hongyan.wdcf.business.test.textview;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

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
