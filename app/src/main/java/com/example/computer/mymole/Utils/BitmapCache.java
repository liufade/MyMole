package com.example.computer.mymole.Utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by computer on 2016/6/20.
 */
public class BitmapCache implements ImageLoader.ImageCache {
    LruCache<String,Bitmap> mCache;

    public BitmapCache(){
        int maxCacheSize=1024*1024*8;
        mCache=new LruCache<String, Bitmap>(maxCacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //需要重写该方法，默认是1，所以需要根据业务需要充
                //LruCache类内部会调用此方法用于计算缓存数量是否达到了maxCacheSize
                return value.getRowBytes()*value.getHeight();
            }
        };
    }
    //从缓存中
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }
//缓存在内存中
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
       mCache.put(url, bitmap);
    }
}
