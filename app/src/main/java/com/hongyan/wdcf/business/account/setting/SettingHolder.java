package com.hongyan.wdcf.business.account.setting;

import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.ItemC;

/**
 * Created by wangning on 2018/6/10.
 */

public class SettingHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    public SettingHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_setting;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return false;
    }

    @Override
    public void initView(View rootView) {
        ItemC itemBank = rootView.findViewById(R.id.item_bank);
        ItemC itemPassword = rootView.findViewById(R.id.item_password);
        itemBank.setOnClickListener(this);
        itemPassword.setOnClickListener(this);
        addLeftButtonDefault();
    }

    @Override
    public int getNavigationTitle() {
        return R.string.setting;
    }

    @Override
    public RequestBean getRequestBean() {
        return null;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_bank:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserBankCardList));
                break;
            case R.id.item_password: {
                Router router = new Router(RouterConfig.UserModifyPassword);
                RouterManager.getInstance().openUrl(router);
                break;
            }
        }
    }
}
