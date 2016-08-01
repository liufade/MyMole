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
import com.example.computer.mymole.Adapter.DiscoverAdapter;
import com.example.computer.mymole.Base.BaseFragment;
import com.example.computer.mymole.R;
import com.example.computer.mymole.Resp.Discover.Discover;
import com.example.computer.mymole.Resp.Discover.DiscoverResp;
import com.example.computer.mymole.Resp.Discover.UsermapsBean;
import com.example.computer.mymole.core.PMApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发现页
 */
public class FindFragment extends BaseFragment {
    String TAG="FindFragment";
    private ListView mListView;
    private DiscoverAdapter discoverAdapter;
    private List<UsermapsBean> mDatas;
    private UsermapsBean[] usermapsBeen=new UsermapsBean[]{};
    private Discover discover;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.fragment_find,null);
        mListView= (ListView) view.findViewById(R.id.discover_listview);
        initView();

        return view;
    }

    private void initView() {
//            usermapsBeen=new UsermapsBean[]{};
            String url="http://service.xunjimap.com/xunjiservice/usermap/squareIndex?6ECB8740D07F817A35E52F955DB0249D";
            discover=new Discover();
            StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "onResponse: "+response);
                    discover= JSONObject.parseObject(response,Discover.class);
                    DiscoverResp dis=discover.getResult();
                    usermapsBeen=dis.getUsermaps();
//                    mDatas=new ArrayList<UsermapsBean>();
//                    for (int i = 0; i <usermapsBeen.length ; i++) {
//                        mDatas.add(usermapsBeen[i]);
//                    }
                    discoverAdapter=new DiscoverAdapter(getContext());
                    discoverAdapter.addAll(dis.getUsermaps());
                    mListView.setAdapter(discoverAdapter);

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
                    map.put("sortType","2");
                    map.put("appuserid","80083");
                    map.put("t","20160727154533");
                    map.put("token","48320B54C33E5A1C9FA2342361762E54ACA36AA5");
                    map.put("sid","L9LyEtHVCI");
                    map.put("imei","163CD92C4D4C4F707972D99AF77092AD");
                    map.put("os","Android+4.4.2");
                    map.put("key","PPZHUSHOU");
                    map.put("page","1");
                    map.put("mapType","1");
                    return map;
                }
            };
            PMApplication.getsIntance().getRequestQueue().add(stringRequest);

    }
}
