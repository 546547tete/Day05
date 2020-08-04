package com.example.liangxq.shopping.app;
import android.app.Application;
import com.example.httplibrary.HttpConstant;
import com.example.httplibrary.HttpGlobalConfig;
public class ShopApplication extends Application {

    String BASE_WANANZHUO="https://www.wanandroid.com/";
    //project/list/1/json?cid=294

    String ERGE="http://api.t.ergedd.com/";
    //getUpgrade

    @Override
    public void onCreate() {
        super.onCreate();
        HttpGlobalConfig.getInsance()
                .setBaseUrl(BASE_WANANZHUO)
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
    }
}
