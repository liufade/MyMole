package com.example.computer.mymole.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.computer.mymole.R;
import com.example.computer.mymole.Resp.mianResp.BannerResp;
import com.example.computer.mymole.Utils.Utils;

import java.util.List;

/**
 * Created by computer on 2016/7/26.
 */
public class ImgAdapter extends PagerAdapter{
    private final int FAKE_BANNER_SIZE = 100;
    private   int DEFAULT_BANNER_SIZE = 5;
    private Context context;
    private List<BannerResp> bannerList;
    private ViewPager mViewPager;
    ImageView image;

    public ImgAdapter(Context context,List<BannerResp> bannerList,ViewPager mViewPager) {
        this.context = context;
        this.bannerList = bannerList;
        this.mViewPager=mViewPager;
        DEFAULT_BANNER_SIZE=bannerList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position%=DEFAULT_BANNER_SIZE;
        View view= LayoutInflater.from(context).inflate(R.layout.vp_item,container,false);
        image= (ImageView) view.findViewById(R.id.vp_item_img);
        Utils.loadImage(bannerList.get(position).getImageurl(),image);

        final int pos=position;
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context,pos+bannerList.get(pos).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        Log.d(TAG, "instantiateItem() called with: " + "container = [" + container + "], position = [" + position + "]");
        container.addView(view);
        return view;
    }

    private static final String TAG = "ImgAdapter";
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return FAKE_BANNER_SIZE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public void finishUpdate(ViewGroup container) {
        //这个有点懵逼..
        int position = mViewPager.getCurrentItem();
        if (position == 0){
            position = DEFAULT_BANNER_SIZE;
            mViewPager.setCurrentItem(position,false);
        }else if (position == FAKE_BANNER_SIZE - 1){
            position = DEFAULT_BANNER_SIZE - 1;
            mViewPager.setCurrentItem(position,false);
        }
    }


}

