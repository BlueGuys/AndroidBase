package com.hongyan.base;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hongyan.lib_base.R;

public abstract class BaseViewHolder {

    protected BaseActivity mActivity;

    protected View rootView;
    protected NavigationView navigationView;
    private LinearLayout contentLayout;
    private LinearLayout businessLayout;
    protected ListView listView;
    private View netErrorLayout;

    public BaseViewHolder(BaseActivity activity) {
        this.mActivity = activity;
        rootView = LayoutInflater.from(activity).inflate(getLayoutId(), null, false);
        initView();
    }

    protected abstract int getLayoutId();

    protected void initView() {

    }

    private void showBusinessLayout() {
        contentLayout.setVisibility(View.VISIBLE);
        netErrorLayout.setVisibility(View.GONE);
    }

    private void showNetErrorLayout() {
        contentLayout.setVisibility(View.GONE);
        netErrorLayout.setVisibility(View.VISIBLE);
    }

    public BaseActivity getActivity() {
        return mActivity;
    }

    public HYBaseAdapter getAdapter() {
        return null;
    }

    protected boolean hideNavigationView() {
        return false;
    }

    protected View getRootView() {
        return rootView;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }

    protected void setNavigationView(NavigationView navigationView) {
        this.navigationView = navigationView;
    }

    protected void addLeftButton(int buttonResId, View.OnClickListener listener) {
        this.navigationView.addLeftButton(buttonResId, listener);
    }

    protected void addLeftButtonDefault() {
        addLeftButton(R.drawable.icon_arrow_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }

    protected boolean enableLoadMore() {
        return false;
    }

    protected boolean enablePullRefresh() {
        return false;
    }

    public void showSuccessToast(String message) {
        mActivity.showSuccessToast(message);
    }

    public void showErrorToast(String message) {
        mActivity.showErrorToast(message);
    }

    public void startLoading() {
        mActivity.startLoading();
    }

    public void goBack() {
        mActivity.finish();
    }

    /**
     * @param isCancelable 是否可以取消
     */
    public void startLoading(boolean isCancelable) {
        mActivity.startLoading(isCancelable);
    }

    public void cancelLoading() {
        mActivity.cancelLoading();
    }

}
