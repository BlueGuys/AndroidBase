package com.hongyan.wdcf.base;


import com.hongyan.base.router.RouterConst;
import com.hongyan.wdcf.business.account.feedback.DeviceInfoActivity;
import com.hongyan.wdcf.business.account.share.UserShareActivity;
import com.hongyan.wdcf.business.test.asynctask.AsyncTaskTestActivity;
import com.hongyan.wdcf.business.test.device.DeviceTestActivity;

public final class RouterConfig {

    private static volatile RouterConfig instance;

    private RouterConfig() {
        init();
    }

    public static RouterConfig getInstance() {
        if (instance == null) {
            synchronized (RouterConfig.class) {
                if (instance == null) {
                    instance = new RouterConfig();
                }
            }
        }
        return instance;
    }

    void init() {
        RouterConst.addRouter(UserUserFeedback, DeviceInfoActivity.class.getName());
        RouterConst.addRouter(UserShare, UserShareActivity.class.getName());
        RouterConst.addRouter(UserActivityPDF, PDFViewActivity.class.getName());
        RouterConst.addRouter(TestAsyncTask, AsyncTaskTestActivity.class.getName());
        RouterConst.addRouter(TestDevice, DeviceTestActivity.class.getName());
    }

    public static final String UserLoginIndex = "native://user/login/index";
    public static final String UserRegisterSelect = "native://user/register/select";
    public static final String UserUserFeedback = "native://user/user/feedback";
    public static final String UserBindTeacher = "native://user/user/bindTeacher";
    /**
     * 我的订单
     */
    public static final String UserOrderList = "native://user/order/list";
    /**
     * 分享邀请
     */
    public static final String UserShare = "native://user/share/index";
    /**
     * 类固收列表
     */
    public static final String ProductListFixed = "native://product/list/fixed";
    /**
     * 私募股权
     */
    public static final String ProductListSimu = "native://product/list/simu";
    /**
     * 海外投资
     */
    public static final String ProductListOverseas = "native://product/list/overseas";
    /**
     * 保险服务
     */
    public static final String ProductListInsurance = "native://product/list/insurance";

    /**
     * 打开PDF
     */
    public static final String UserActivityPDF = "native://user/activity/pdf";

    /**
     * AsyncTask
     */
    public static final String TestAsyncTask = "native://test/activity/async";

    /**
     * DeviceTest
     */
    public static final String TestDevice = "native://test/activity/device";


}
