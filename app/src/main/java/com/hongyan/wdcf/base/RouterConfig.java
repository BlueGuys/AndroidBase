package com.hongyan.wdcf.base;


import com.hongyan.base.router.RouterConst;
import com.hongyan.wdcf.business.account.bankcard.BankCardListActivity;
import com.hongyan.wdcf.business.account.bankcard.BindBankCardActivity;
import com.hongyan.wdcf.business.account.bindteacher.BindTeacherActivity;
import com.hongyan.wdcf.business.account.feedback.FeedbackActivity;
import com.hongyan.wdcf.business.account.order.OrderDetailActivity;
import com.hongyan.wdcf.business.teacher.activitydetail.ActivityDetailActivity;
import com.hongyan.wdcf.business.teacher.customerList.CustomerAllListActivity;
import com.hongyan.wdcf.business.teacher.introduction.ModifyIntroductionActivity;
import com.hongyan.wdcf.business.teacher.invite.InviteActivity;
import com.hongyan.wdcf.business.account.login.LoginActivity;
import com.hongyan.wdcf.business.account.modifyloginpassword.ModifyLoginPasswordActivity;
import com.hongyan.wdcf.business.account.modifytradepassword.ModifyTradePasswordActivity;
import com.hongyan.wdcf.business.account.order.OrderListActivity;
import com.hongyan.wdcf.business.account.password.PasswordActivity;
import com.hongyan.wdcf.business.account.register.RegisterActivity;
import com.hongyan.wdcf.business.account.select.SelectIdentifyActivity;
import com.hongyan.wdcf.business.account.setting.SettingActivity;
import com.hongyan.wdcf.business.account.share.UserShareActivity;
import com.hongyan.wdcf.business.account.user.UserInfoActivity;
import com.hongyan.wdcf.business.teacher.customer.CustomerListActivity;
import com.hongyan.wdcf.business.product.equity.SimuListActivity;
import com.hongyan.wdcf.business.product.fixed.FixedProductListActivity;
import com.hongyan.wdcf.business.product.insurance.InsuranceListActivity;
import com.hongyan.wdcf.business.product.overseas.OverseasProductListActivity;
import com.hongyan.wdcf.business.teacher.orderstatus.OrderStatusActivity;
import com.hongyan.wdcf.business.teacher.subscribe.SubscribeActivity;
import com.hongyan.wdcf.business.teacher.addrecord.AddRecordActivity;
import com.hongyan.wdcf.business.teacher.info.TeacherInfoActivity;
import com.hongyan.wdcf.business.test.asynctask.AsyncTaskTestActivity;
import com.hongyan.wdcf.business.user.study.StudyListActivity;

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
        RouterConst.addRouter(UserLoginIndex, LoginActivity.class.getName());
        RouterConst.addRouter(UserRegisterIndex, RegisterActivity.class.getName());
        RouterConst.addRouter(UserRegisterSelect, SelectIdentifyActivity.class.getName());
        RouterConst.addRouter(UserInfoIndex, UserInfoActivity.class.getName());
        RouterConst.addRouter(UserUserFeedback, FeedbackActivity.class.getName());
        RouterConst.addRouter(UserUserSetting, SettingActivity.class.getName());
        RouterConst.addRouter(UserModifyPassword, PasswordActivity.class.getName());
        RouterConst.addRouter(UserBankCardList, BankCardListActivity.class.getName());
        RouterConst.addRouter(UserBindBankCard, BindBankCardActivity.class.getName());
        RouterConst.addRouter(UserBindTeacher, BindTeacherActivity.class.getName());
        RouterConst.addRouter(UserModifyLoginPasswrod, ModifyLoginPasswordActivity.class.getName());
        RouterConst.addRouter(UserModifyTradePasswrod, ModifyTradePasswordActivity.class.getName());
        RouterConst.addRouter(UserOrderList, OrderListActivity.class.getName());
        RouterConst.addRouter(UserShare, UserShareActivity.class.getName());
        RouterConst.addRouter(CustomerInfo, CustomerListActivity.class.getName());
        RouterConst.addRouter(Subscribe, SubscribeActivity.class.getName());
        RouterConst.addRouter(UserInvite, InviteActivity.class.getName());
        RouterConst.addRouter(TearcherAddRecord, AddRecordActivity.class.getName());
        RouterConst.addRouter(ProductListFixed, FixedProductListActivity.class.getName());
        RouterConst.addRouter(ProductListSimu, SimuListActivity.class.getName());
        RouterConst.addRouter(ProductListOverseas, OverseasProductListActivity.class.getName());
        RouterConst.addRouter(ProductListInsurance, InsuranceListActivity.class.getName());
        RouterConst.addRouter(TeacherInfoIndex, TeacherInfoActivity.class.getName());
        RouterConst.addRouter(TeacherIntroductionModify, ModifyIntroductionActivity.class.getName());
        RouterConst.addRouter(TeacherOrderStatusEdit, OrderStatusActivity.class.getName());
        RouterConst.addRouter(TeacherCustomerList, CustomerAllListActivity.class.getName());
        RouterConst.addRouter(UserOrderDetail, OrderDetailActivity.class.getName());
        RouterConst.addRouter(UserStudyList, StudyListActivity.class.getName());
        RouterConst.addRouter(UserActivityDetail, ActivityDetailActivity.class.getName());
        RouterConst.addRouter(UserActivityPDF, PDFViewActivity.class.getName());
        RouterConst.addRouter(TestAsyncTask, AsyncTaskTestActivity.class.getName());
    }

    public static final String UserLoginIndex = "native://user/login/index";
    public static final String UserRegisterIndex = "native://user/register/index";
    public static final String UserRegisterSelect = "native://user/register/select";
    public static final String UserInfoIndex = "native://user/info/index";
    public static final String UserUserFeedback = "native://user/user/feedback";
    public static final String UserUserSetting = "native://user/user/setting";
    public static final String UserModifyPassword = "native://user/user/password";
    public static final String UserBankCardList = "native://user/bankcard/list";
    public static final String UserBindBankCard = "native://user/bankcard/bind";
    public static final String UserBindTeacher = "native://user/user/bindTeacher";
    public static final String UserModifyLoginPasswrod = "native://user/user/modifyloginpassword";
    public static final String UserModifyTradePasswrod = "native://user/user/modifytradepassword";
    /**
     * 邀请您加入
     */
    public static final String UserInvite = "native://user/invite";
    /**
     * 客户信息
     */
    public static final String CustomerInfo = "native://customer/info/list";
    /**
     * 我的订单
     */
    public static final String UserOrderList = "native://user/order/list";
    /**
     * 分享邀请
     */
    public static final String UserShare = "native://user/share/index";
    /**
     * 预约处理
     */
    public static final String Subscribe = "native://subscribe";
    /**
     * 增加聊天记录
     */
    public static final String TearcherAddRecord = "native://teacher/add/record";
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
     * 理财师->个人信息
     */
    public static final String TeacherInfoIndex = "native://teacher/info/index";
    /**
     * 理财师->提交个人介绍
     */
    public static final String TeacherIntroductionModify = "native://teacher/introduction/modify";
    /**
     * 理财师->设置受理状态
     */
    public static final String TeacherOrderStatusEdit = "native://teacher/order/status";
    /**
     * 理财师->我的客户列表
     */
    public static final String TeacherCustomerList = "native://teacher/customer/list";
    /**
     * 订单详情
     */
    public static final String UserOrderDetail = "native://user/order/detail";
    /**
     * 学习
     */
    public static final String UserStudyList = "native://user/study/list";
    /**
     * 订单详情
     */
    public static final String UserActivityDetail = "native://user/activity/detail";
    /**
     * 打开PDF
     */
    public static final String UserActivityPDF = "native://user/activity/pdf";

    /**
     * 打开PDF
     */
    public static final String TestAsyncTask = "native://test/activity/async";

}
