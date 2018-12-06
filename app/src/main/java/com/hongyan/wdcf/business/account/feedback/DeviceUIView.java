package com.hongyan.wdcf.business.account.feedback;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hongyan.wdcf.R;

public class DeviceUIView extends LinearLayout {

    private View view;

    public DeviceUIView(Context context) {
        super(context);
    }

    public DeviceUIView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.device_ui_view, this, true);
    }
}
