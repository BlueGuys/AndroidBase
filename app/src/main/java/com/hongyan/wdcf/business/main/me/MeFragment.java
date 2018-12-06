package com.hongyan.wdcf.business.main.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hongyan.base.BaseFragment;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.ItemA;

public class MeFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ItemA item01 = view.findViewById(R.id.item_01);
        ItemA item02 = view.findViewById(R.id.item_02);
        ItemA item03 = view.findViewById(R.id.item_03);
        ItemA item04 = view.findViewById(R.id.item_04);
        item01.setOnClickListener(this);
        item02.setOnClickListener(this);
        item03.setOnClickListener(this);
        item04.setOnClickListener(this);
        return view;
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
