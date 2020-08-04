package com.example.liangxq.shopping.app;

import android.util.Log;

import com.example.httplibrary.callback.BaseCallBack;
import com.example.httplibrary.demo.Response;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class HttpCallBac<T> extends BaseCallBack<T> {
    WanResponse response;
    @Override
    protected T onConvert(String result) {
        T t=null;
        response = new Gson().fromJson(result, WanResponse.class);
        JsonElement data = response.getData();
        int errorCode = response.getErrorCode();
        String errorMsg = response.getErrorMsg();
        switch (errorCode) {
            case -1001:
                onError("登陆失败",errorCode);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
                break;
        }
        Log.e("TRG", "onConvert: "+t.toString() );
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (response != null) {
            return response.getErrorCode() == 0;
        }
        return false;
    }

}
