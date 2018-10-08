package com.hongyan.wdcf.business.test.device;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.lahm.library.EasyProtectorLib;

/**
 * Created by wangning on 2018/6/10.
 */

public class DeviceTestHolder extends BaseViewHolder implements IViewHolder {

    private TextView textView;
    private Button button;

    public DeviceTestHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_device_test;
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
        textView = rootView.findViewById(R.id.textView);
        button = rootView.findViewById(R.id.btn_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(EasyProtectorLib.checkIsRunningInEmulator() ? "yes" : "no");
            }
        });
    }

    @Override
    public int getNavigationTitle() {
        return 0;
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

    public void getTelephonyInfo(Context context) {
        if (context == null) {
            return;
        }
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // 如果权限没有被允许
            return;
        }
        String deviceid = tm.getDeviceId();//获取IMEI号
        String te1 = tm.getLine1Number();//获取本机号码
        String imei = tm.getSimSerialNumber();//获得SIM卡的序号
        String imsi = tm.getSubscriberId();//得到用户Id
    }
}
