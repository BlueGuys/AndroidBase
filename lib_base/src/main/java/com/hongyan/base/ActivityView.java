package com.hongyan.base;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ActivityView extends LinearLayout {

    private Context mContext;
    protected View rootView;

    public ActivityView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        this.mContext = context;
        addTipView();
    }

    protected void addBusinessView(int layoutId) {
        if (layoutId <= 0) {
            throw new IllegalAccessError("参数错误");
        }
        rootView = View.inflate(mContext, layoutId, null);
        addBusinessView(rootView);
    }

    protected void addBusinessView(View businessView) {
        removeAllViews();
        rootView = businessView;
        ViewGroup.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(businessView, lp);
    }

    private void addTipView() {
        TextView textView = new TextView(mContext);
        textView.setText("请设置业务布局,调用ActivityView.addBusinessView()方法进行设置");
        textView.setTextColor(Color.BLUE);
        ViewGroup.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(textView, lp);
    }

}
