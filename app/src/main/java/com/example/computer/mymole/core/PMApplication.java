package com.example.computer.mymole.core;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;


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
        initUI();
    }

    private void initUI() {
        File cacherDir= StorageUtils.getOwnCacheDirectory(this,"imageload/image");
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .diskCache(new UnlimitedDiskCache(cacherDir))
                .diskCacheSize(50*1024*1024)
                .imageDownloader(new BaseImageDownloader(this,20*60*60,30*60*60))
                .diskCacheFileCount(100)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        ImageLoader.getInstance().init(config);

    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
