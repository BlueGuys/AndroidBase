package com.hongyan.wdcf.business.device;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.R;

public class DeviceHolder extends BaseViewHolder {

    private DeviceInfoView deviceInfoView;
    private DeviceUIView deviceUIView;

    public DeviceHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_device_info;
    }

    @Override
    public void initView() {
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
}
