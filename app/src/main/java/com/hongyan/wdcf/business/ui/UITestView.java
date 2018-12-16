package com.hongyan.wdcf.business.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.hongyan.base.ActivityView;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.device.ScreenUtils;

public class UITestView extends ActivityView {

    private LinearLayout rootLayout;
    private EditText editText;
    private Button button;

    public UITestView(Context context) {
        super(context);
        addBusinessView(R.layout.activity_uitest);
        initView();
    }

    protected void initView() {
        if (rootView == null) {
            return;
        }
        rootLayout = rootView.findViewById(R.id.linearLayout);
        editText = rootView.findViewById(R.id.editText);
        button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = 0;
                try {
                    s = Integer.parseInt(editText.getText().toString());
                } catch (Exception e) {
                }
                addSubView(s);
            }
        });
    }

    private void addSubView(int length) {
        View view = new View(mContext);
        view.setBackgroundColor(Color.RED);
        ViewGroup.LayoutParams lp = new LayoutParams(ScreenUtils.getRealDimen(length), ScreenUtils.getRealDimen(30));
        ((LayoutParams) lp).bottomMargin = ScreenUtils.getRealDimen(10);
        rootLayout.addView(view, lp);
    }
}