package com.hongyan.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.hongyan.loading.LoadingDialog;

/**
 * com.jp.base.BaseActivity
 */
public abstract class BaseActivity extends FragmentActivity {

    private LoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void init() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//限制为竖屏
        configTranslucentStatuBar();
    }

    protected String getParam(String key) {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return "";
        }
        return bundle.getString(key);
    }

    /**
     * 设置为沉浸式(半透明)状态栏
     */
    private void configTranslucentStatuBar() {
        if (!useTranslucentStatus()) {
            return;
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(setStatusBarColor());
    }

    /**
     * 设置状态栏的颜色
     */
    public int setStatusBarColor() {
        return Color.WHITE;
    }

    /**
     * 是否启用沉浸式(半透明)状态栏
     */
    public boolean useTranslucentStatus() {
        return true;
    }


    public void showSuccessToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void startLoading() {
        startLoading(true);
    }

    /**
     * @param isCancelable 是否可以取消
     */
    public void startLoading(boolean isCancelable) {
        if (dialog == null) {
            dialog = new LoadingDialog(this);
            dialog.setCancelable(isCancelable);
        }
        dialog.show();
    }

    public void cancelLoading() {
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }
}
