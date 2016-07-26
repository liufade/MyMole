package com.example.computer.mymole.core;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by computer on 2016/7/22.
 */
public class BitmapCache implements ImageLoader.ImageCache {
    LruCache<String,Bitmap> mCache;

    public BitmapCache(){
        int maxCacheSiza=1024*1024*8;
        mCache=new LruCache<String, Bitmap>(maxCacheSiza){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getHeight()*value.getRowBytes();
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}
