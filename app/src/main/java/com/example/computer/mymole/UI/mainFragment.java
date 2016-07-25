package com.example.computer.mymole.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.computer.mymole.Adapter.mainListViewAdapter;
import com.example.computer.mymole.Base.BaseFragment;
import com.example.computer.mymole.R;
import com.example.computer.mymole.Resp.mianResp.HomeJinXuanEntity;
import com.example.computer.mymole.Resp.mianResp.HomeJinXuanResp;
import com.example.computer.mymole.core.PMApplication;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by computer on 2016/7/21.
 */
public class mainFragment extends BaseFragment {

    private static final String TAG ="TAG" ;
    private ListView mListView;
    HomeJinXuanEntity mDatas;
//    Banner_Recommend[] mDatas;
    mainListViewAdapter listViewAdapter;
    Gson gson;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=View.inflate(getActivity(), R.layout.mian_fragment,null);
        mListView= (ListView) view.findViewById(R.id.main_fragment_listview);
        initData();
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

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: "+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
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



}
