package com.hongyan.wdcf.business.main;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.TokenMessageEvent;
import com.hongyan.base.tab.SubPage;
import com.hongyan.base.tab.TabActivity;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.core.MainMessageEvent;
import com.hongyan.wdcf.business.account.core.TabChangeEvent;
import com.hongyan.wdcf.business.main.discover.DiscoverFragment;
import com.hongyan.wdcf.business.main.me.MeFragment;
import com.hongyan.wdcf.business.main.service.ServiceFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends TabActivity {

    public final static String TAG = MainActivity.class.getSimpleName();
    private long exitTime = 0;
    private final static long DOUBLE_BACK_TIME = 2000; // 两次back的间隔时间：2s

    /**
     * 权限请求码
     */
    private final static int PERMISSION_REQUEST_CODE = 0x111;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<SubPage> list = new ArrayList<>();
        SubPage discoverPage = new SubPage();
        discoverPage.fragment = new DiscoverFragment();
        discoverPage.text = "发现";
        discoverPage.drawable = new int[]{R.drawable.icon_discover_s, R.drawable.icon_discover_n};

        SubPage servicePage = new SubPage();
        servicePage.fragment = new ServiceFragment();
        servicePage.text = "服务";
        servicePage.drawable = new int[]{R.drawable.icon_service_s, R.drawable.icon_service_n};

        SubPage mePage = new SubPage();
        mePage.fragment = new MeFragment();
        mePage.text = "我的";
        mePage.drawable = new int[]{R.drawable.icon_me_s, R.drawable.icon_me_n};

        list.add(discoverPage);
        list.add(servicePage);
        list.add(mePage);
        addSubPage(list);
        EventBus.getDefault().register(this);
        AccountManager.getInstance().refresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void accountEvent(MainMessageEvent message) {
        if (message == null) {
            return;
        }
        selectPage(message.getPosition());
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void tokenEvent(TokenMessageEvent message) {
//        if (message == null) {
//            return;
//        }
//        AccountManager.getInstance().logout();
//        AccountManager.getInstance().checkLogin();
    }

    @Override
    protected void select(int position) {
        super.select(position);
//        if (position == 2) {
//            AccountManager.getInstance().checkLogin();
//        }
//        EventBus.getDefault().post(new TabChangeEvent(position));
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return super.getViewHolder();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() != KeyEvent.KEYCODE_BACK) {
            return super.dispatchKeyEvent(event);
        }
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > DOUBLE_BACK_TIME) {
                showErrorToast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
        }
        return true;
    }

    /**
     * 请求相机权限
     */
    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    Toast.makeText(this, "Please grant camera permission first", Toast.LENGTH_SHORT).show();
                } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "Please grant camera permission first", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
                    Log.e(TAG, "请求系统sd卡写权限和相机权限");
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length == 2) {
                Log.e(TAG, "sd卡权限:" + grantResults[0]);
                Log.e(TAG, "相机权限:" + grantResults[1]);
            }
        }
    }
}
