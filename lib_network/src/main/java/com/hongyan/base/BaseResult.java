package com.hongyan.base;

/**
 * com.jp.base.BaseResult
 */
public class BaseResult {

    protected Error error;

    public static class Error {
        public String errorCode;
        public String errorMessage;
    }

    public String getReturnCode() {
        String ret = "";
        if (error != null) {
            ret = error.errorCode;
        }
        return ret;
    }

    public String getReturnMessage() {
        String ret = "";
        if (error != null) {
            ret = error.errorMessage;
        }
        return ret;
    }

    public boolean isSuccessful() {
        String returnCode = String.valueOf(getReturnCode());
        return "10000".equals(returnCode);
    }

    public static Error getVolleyError() {
        Error error = new Error();
        error.errorCode = "100";
        error.errorMessage = "网络异常，请稍后重试";
        return error;
    }

    public static Error getAnalysisError() {
        Error error = new Error();
        error.errorCode = "200";
        error.errorMessage = "解析错误";
        return error;
    }
}
