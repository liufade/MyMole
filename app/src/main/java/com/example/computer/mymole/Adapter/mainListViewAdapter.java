package com.example.computer.mymole.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.computer.mymole.R;
import com.example.computer.mymole.Resp.mianResp.RecommendResp;
import com.example.computer.mymole.core.BitmapCache;
import com.example.computer.mymole.core.PMApplication;

/**
 * Created by computer on 2016/7/22.
 */
public class mainListViewAdapter extends ArrayAdapter{

    private ImageLoader imageLoader;

    public mainListViewAdapter(Context context) {
        super(context,0);
        imageLoader=new ImageLoader(PMApplication.getsIntance().getRequestQueue(),new BitmapCache());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(parent.getContext(), R.layout.mian_fragment_listview_item,null);
            viewHolder=new ViewHolder(convertView);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        RecommendResp recommendResp= (RecommendResp) getItem(position);
//        Banner_Recommend banner_recommend= (Banner_Recommend) getItem(position);
        viewHolder.mian_item_img.setImageUrl(recommendResp.getImageurl(),imageLoader);
        return convertView;
    }

    public class ViewHolder{
        NetworkImageView mian_item_img;

       ViewHolder(View view){
           mian_item_img= (NetworkImageView) view.findViewById(R.id.mian_listview_item_img);
           view.setTag(this);
       }
   }
}
