package com.hongyan.wdcf.business.main.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hongyan.base.BaseFragment;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.core.AccountMessageEvent;
import com.hongyan.wdcf.widget.ItemA;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MeFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ItemA item01;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        item01 = view.findViewById(R.id.item_01);
        item01.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_01:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.TestAsyncTask));
                break;
        }
    }
}
