package com.example.computer.mymole.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.computer.mymole.Adapter.ImgAdapter;
import com.example.computer.mymole.Adapter.mainListViewAdapter;
import com.example.computer.mymole.Base.BaseFragment;
import com.example.computer.mymole.R;
import com.example.computer.mymole.Resp.mianResp.BannerResp;
import com.example.computer.mymole.Resp.mianResp.HomeJinXuanEntity;
import com.example.computer.mymole.Resp.mianResp.HomeJinXuanResp;
import com.example.computer.mymole.core.PMApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * Created by computer on 2016/7/21.
 */
public class mainFragment extends BaseFragment {

    private static final String TAG ="TAG" ;
    private ListView mListView;
    HomeJinXuanEntity mDatas;
//    Banner_Recommend[] mDatas;
    mainListViewAdapter listViewAdapter;
    private ViewPager mViewPager;
    private ImgAdapter imgAdapter;
    private BannerResp[] banner;
    private Timer timer=new Timer();
    private List<BannerResp> bannerList;
    private ImageView[] mIndicator;

    private int mBannerPosition = 0;
    private final int FAKE_BANNER_SIZE = 100;
    private final int DEFAULT_BANNER_SIZE = 5;
    private boolean mIsUserTouched = false;

//    private TimerTask timerTask=new TimerTask() {
//        @Override
//        public void run() {
//           if (!mIsUserTouched){
//               mBannerPosition=(mBannerPosition+1)%FAKE_BANNER_SIZE;
               /**
                * android在子线程更新UI的几种方法
                * Handler，AsyncTask,View.post,runOnUiThread
                */
//               View.post(new Runnable() {
//                   @Override
//                   public void run() {
//                       if (mBannerPosition == FAKE_BANNER_SIZE - 1){
//                           mViewPager.setCurrentItem(DEFAULT_BANNER_SIZE - 1,false);
//                       }else {
//                           mViewPager.setCurrentItem(mBannerPosition);
//                       }
//                   }
//               });
//           }
//        }
//    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=View.inflate(getActivity(), R.layout.mian_fragment,null);
        mListView= (ListView) view.findViewById(R.id.main_fragment_listview);
        mViewPager= (ViewPager) view.findViewById(R.id.mian_fragment_viewPager);
//        String[] userid = {"aa","bb","cc"};
//        List<String> userList = new ArrayList<String>();
//        Collections.addAll(userList, userid);
        mIndicator = new ImageView[]{
                (ImageView) view.findViewById(R.id.dot_indicator1),
                (ImageView) view.findViewById(R.id.dot_indicator2),
                (ImageView) view.findViewById(R.id.dot_indicator3),
                (ImageView) view.findViewById(R.id.dot_indicator4),
                (ImageView) view.findViewById(R.id.dot_indicator5),
        };
        initView();

        return view;
    }



    private void initData() {
        String url="http://service.xunjimap.com/xunjiservice/index?8240ED4B3DEE183E70F37F724F0169C6";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: "+response);
                HomeJinXuanResp hjxr= JSONObject.parseObject(response,HomeJinXuanResp.class);
                mDatas=hjxr.getResult();
                listViewAdapter=new mainListViewAdapter(getContext());
                listViewAdapter.addAll(mDatas.getRecommendList() );
                mListView.setAdapter(listViewAdapter);
                banner=mDatas.getBannerList();
                Log.d(TAG, "banner: "+banner);
                bannerList=new ArrayList<BannerResp>();
//                Collections.addAll(bannerList,banner);
//                ArrayList<String> array = new ArrayList<String>();
                for(int i = 0;i < banner.length+1;i++){
                    bannerList.add(banner[i]);
                    Log.d(TAG, "bannerList: "+bannerList);
                }

                imgAdapter=new ImgAdapter(getContext(),bannerList,mViewPager);
                mViewPager.setAdapter(imgAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: "+error);
            }
        }){
            @Override
            protected  Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<String, String>();
                map.put("userinfoid","52639");
                map.put("appuserid","80083");
                map.put("t","20160720093402");
                map.put("token","AF5C47AB5F630410E4420D28299D280F4F35E5EF");
                map.put("sid","NqOUlxdmOT");
                map.put("imei","163CD92C4D4C4F707972D99AF77092AD");
                map.put("os","Android+4.4.2");
                map.put("key","PPZHUSHOU");
                map.put("usermapid","205724");
                return map;
            }
        };
        PMApplication.getsIntance().getRequestQueue().add(stringRequest);
    }

    private void initView() {
        //dot
        //loadData
        initData();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Touch
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE){
                    mIsUserTouched = true;
                }else if (action == MotionEvent.ACTION_UP){
                    mIsUserTouched = false;
                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBannerPosition = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initEvent();
    }
    private void initEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBannerPosition = position;
                setIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setIndicator(int position) {
        position %= DEFAULT_BANNER_SIZE;
        //遍历mIndicator重置src为normal
        for (ImageView indicator : mIndicator){
            indicator.setImageResource(R.drawable.dot_normal);
        }
        mIndicator[position].setImageResource(R.drawable.dot_focused);
//        mTitle.setText(news.getTop_stories().get(position).getTitle());
    }


}
