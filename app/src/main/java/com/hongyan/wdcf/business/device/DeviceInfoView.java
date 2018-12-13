package com.hongyan.wdcf.business.device;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hongyan.base.ActivityView;
import com.hongyan.wdcf.R;
import com.lahm.library.EasyProtectorLib;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;

public class DeviceInfoView extends ActivityView {

    private DeviceDataView deviceInfoView;
    private DeviceUIView deviceUIView;
    private Context mContext;

    public DeviceInfoView(Context context) {
        super(context);
        this.mContext = context;
        addBusinessView(R.layout.activity_device_info);
        initView();
    }

    protected void initView() {
        deviceInfoView = rootView.findViewById(R.id.view_device_info);
        deviceUIView = rootView.findViewById(R.id.view_device_ui);
        DeviceInfo deviceInfo = DeviceUtils.getInstance(mContext).exec();
        deviceInfoView.setText(deviceInfo.toString());
    }

}
