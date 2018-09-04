package com.hongyan.wdcf.business.test.asynctask;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.NetworkCall;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class AsyncTaskTestModel extends BaseModel {

    private AsyncTaskTestHolder viewHolder;

    public AsyncTaskTestModel(AsyncTaskTestHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void login(String mobilePhone, String password) {
        viewHolder.startLoading();
        NetworkCall registerCall = new NetworkCall<>();
        registerCall.setRequestUrl(UrlConst.getLoginUrl());
        registerCall.setResultClass(AsyncTaskTestResult.class);
        registerCall.addParam(RequestKeyTable.MOBILE, mobilePhone);
        registerCall.addParam(RequestKeyTable.PASSWORD, password);
        registerCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                viewHolder.cancelLoading();
                AsyncTaskTestResult registerResult = (AsyncTaskTestResult) result;
                if (registerResult.isSuccessful()) {
                    AsyncTaskTestResult.Data data = registerResult.data;
                    if (data != null) {
                        AccountManager.getInstance().setToken(data.token);
                        viewHolder.showSuccessToast("登录成功");
                        viewHolder.goBack();
                    } else {
                        viewHolder.showErrorToast("数据错误");
                    }
                } else {
                    viewHolder.showErrorToast(registerResult.getReturnMessage());
                }
            }

            @Override
            public void onError(BaseResult.Error error) {
                viewHolder.cancelLoading();
                viewHolder.showErrorToast(error.errorMessage);
            }
        });
    }
}
