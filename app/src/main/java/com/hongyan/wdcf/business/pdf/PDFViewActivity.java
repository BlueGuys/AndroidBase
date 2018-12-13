package com.hongyan.wdcf.business.pdf;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;

public class PDFViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PDFHolder pdfHolder = new PDFHolder(this);
        pdfHolder.setmUrl(getParam("url"));
        setContentView(pdfHolder.getLayoutId());
    }


}
