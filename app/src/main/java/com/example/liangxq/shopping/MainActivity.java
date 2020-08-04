package com.example.liangxq.shopping;

import android.os.Bundle;
import android.util.Log;
import com.example.httplibrary.callback.HttpCallBack;
import com.example.httplibrary.client.HttpClient;
import com.example.liangxq.shopping.app.Cid294Bean;
import com.example.liangxq.shopping.app.HttpCallBac;
import com.example.liangxq.shopping.app.LoginBean;
import com.example.liangxq.shopping.app.Pos1Bean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public class MainActivity extends RxAppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //wananzhuo();

       denglu();

    }

    public void denglu() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","tete");
        map.put("password","123456");
        new HttpClient.Builder()
                .setApiUrl("user/login")
                .post()
                .setJsonBody("1",false)
                .setParamser(map)
                .build()
                .request(new HttpCallBac<LoginBean>() {

                    @Override
                    public void onError(String message, int code) {
                    Log.e("111",message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public  void onSuccess(LoginBean loginBean) {
                              Log.e("111",loginBean.toString());
                    }

                    @Override
                    public LoginBean convert(JsonElement result) {
                        return new Gson().fromJson(new Gson().toJson(result.toString()),LoginBean.class);
                    }
                });

    }

    public void wananzhuo() {
        new HttpClient.Builder()
                .setApiUrl("project/list/1/json?cid=294")
                .get()
//                .setJsonBody("{\"parentId\":\"0\"}",true)
                .build()
                .request(new HttpCallBack<Cid294Bean>() {
                    @Override
                    public void onSuccess(Cid294Bean cid294Bean) {
                        Log.e("TRG","成功："+cid294Bean.toString());
                    }

                    @Override
                    public Cid294Bean convert(JsonElement result) {
                        return new Gson().fromJson(result,Cid294Bean.class);
                    }

                    @Override
                    public void onError(String message, int code) {
                        Log.e("TRG","onError："+message);
                    }

                    @Override
                    public void cancle() {

                    }
                });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
