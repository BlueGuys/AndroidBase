package com.hongyan.wdcf.business.pdf;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

public class PDFViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PDFView(this));
    }
}
