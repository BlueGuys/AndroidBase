package com.hongyan.wdcf.business.main;

import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.ItemA;

public class MainViewHolder extends BaseViewHolder implements View.OnClickListener {

    public MainViewHolder(BaseActivity activity) {
        super(activity);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ItemA item01 = rootView.findViewById(R.id.item_01);
        ItemA item02 = rootView.findViewById(R.id.item_02);
        ItemA item03 = rootView.findViewById(R.id.item_03);
        ItemA item04 = rootView.findViewById(R.id.item_04);
        item01.setOnClickListener(this);
        item02.setOnClickListener(this);
        item03.setOnClickListener(this);
        item04.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_01:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.TestAsyncTask));
                break;
            case R.id.item_02:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.TestDevice));
                break;
            case R.id.item_03:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserUserFeedback));
                break;
            case R.id.item_04:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.TestTextView));
                break;
        }
    }

}