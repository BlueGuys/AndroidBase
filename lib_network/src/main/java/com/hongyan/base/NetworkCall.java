package com.hongyan.base;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.hongyan.StringUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

/**
 * Created by wangning on 2018/6/10.
 */

public class NetworkCall<T extends BaseResult> {

    private BaseRequest request;
    private String requestUrl;
    private Class<T> resultClass;
    private HashMap<String, String> mMap = new HashMap();

    public NetworkCall() {

    }

    public void start(final RequestListener listener) {
        BaseModel baseModel = new BaseModel();
        request = new BaseRequest<>(resultClass, requestUrl, new Response.Listener<BaseResponse>() {
            @Override
            public void onResponse(BaseResponse response) {
                if (listener == null) {
                    return;
                }
                if (response == null || response.getResult() == null) {
                    listener.onError(BaseResult.getAnalysisError());
                    return;
                }
                BaseResult result = response.getResult();
                if (result == null) {
                    return;
                }
                if (StringUtils.notEmpty(result.getReturnCode()) && result.getReturnCode().equals("50003")) {
                    EventBus.getDefault().post(new TokenMessageEvent(false));
                    return;
                }
                listener.onResponse(result);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onError(BaseResult.getVolleyError());
                }
            }
        });
        request.addParam(mMap);
        baseModel.sendRequest(request);
    }

    public void setResultClass(Class<T> resultClass) {
        this.resultClass = resultClass;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void addParam(String key, String value) {
        mMap.put(key, value);
    }

    public void addParam(HashMap<String, String> params) {
        mMap.putAll(params);
    }


}
