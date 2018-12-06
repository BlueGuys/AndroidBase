package com.hongyan.wdcf.business.account.feedback;

import android.view.View;
import android.widget.Button;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;

public class DeviceHolder extends BaseViewHolder implements IViewHolder {

    private DeviceInfoView deviceInfoView;
    private DeviceUIView deviceUIView;

    public DeviceHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_device_info;
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
        addLeftButtonDefault();
        deviceInfoView = rootView.findViewById(R.id.view_device_info);
        deviceUIView = rootView.findViewById(R.id.view_device_ui);
        DeviceInfo deviceInfo = DeviceUtils.getInstance(mActivity).exec();
        deviceInfoView.setText(deviceInfo.toString());
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }

    @Override
    public int getNavigationTitle() {
        return R.string.get_device_info;
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
}
