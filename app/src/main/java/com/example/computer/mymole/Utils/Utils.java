package com.example.computer.mymole.Utils;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class Utils {
    public static void loadImage(String url,ImageView image){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .resetViewBeforeLoading(true)
                .build();

        ImageLoader.getInstance().displayImage(url, image, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
//                Log.d(TAG, "onLoadingStarted() called with: " + "imageUri = [" + imageUri + "], view = [" + view + "]");
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                Log.d(TAG, "onLoadingFailed() called with: " + "imageUri = [" + imageUri + "], view = [" + view + "], failReason = [" + failReason + "]");
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                view.setTag(imageUri);
//                Log.d(TAG, "onLoadingComplete() called with: " + "imageUri = [" + imageUri + "], view = [" + view + "], loadedImage = [" + loadedImage + "]");
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
//                Log.d(TAG, "onLoadingCancelled() called with: " + "imageUri = [" + imageUri + "], view = [" + view + "]");
            }
        });
    }

    private static final String TAG = "Utils";
}