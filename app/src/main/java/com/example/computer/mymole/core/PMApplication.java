package com.example.computer.mymole.core;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 * Created by computer on 2016/7/22.
 */
public class PMApplication extends Application {
    //volley请求
    private RequestQueue requestQueue;
    private static PMApplication sIntance;

    public static PMApplication getsIntance() {
        return sIntance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sIntance=this;
        requestQueue= Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
