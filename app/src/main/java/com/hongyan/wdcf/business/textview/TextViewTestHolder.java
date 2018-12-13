package com.hongyan.wdcf.business.textview;

import android.widget.TextView;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.R;

public class TextViewTestHolder extends BaseViewHolder {

    private TextView textView;

    public TextViewTestHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_textview;
    }

    @Override
    public void initView() {
        textView = rootView.findViewById(R.id.textView);
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }

}
