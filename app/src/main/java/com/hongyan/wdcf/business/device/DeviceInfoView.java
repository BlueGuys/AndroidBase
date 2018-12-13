package com.hongyan.wdcf.business.device;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;

public class DeviceInfoView extends LinearLayout {

    private View view;
    private TextView textView;

    public DeviceInfoView(Context context) {
        super(context);
    }

    public DeviceInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.device_info_view, this, true);
        textView = view.findViewById(R.id.tv_content);
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
