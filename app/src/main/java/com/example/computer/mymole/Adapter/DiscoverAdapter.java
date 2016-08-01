package com.example.computer.mymole.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.computer.mymole.R;
import com.example.computer.mymole.Resp.Discover.UsermapsBean;
import com.example.computer.mymole.core.BitmapCache;
import com.example.computer.mymole.core.PMApplication;

/**
 * Created by computer on 2016/7/27.
 */
public class DiscoverAdapter extends ArrayAdapter{

    private static final String TAG = "TAG";
    private String URL="http://image.xunjimap.com/image/";
    private ImageLoader imageLoader;
//    private List<UsermapsBean> mDatas;
//    private UsermapsBean[] usermapsBeen;

    public DiscoverAdapter(Context context) {
        super(context,0);
//        this.mDatas=mDatas;
        imageLoader= new ImageLoader(PMApplication.getsIntance().getRequestQueue(),new BitmapCache());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewholder=null;
        if (viewholder==null){
            convertView=View.inflate(parent.getContext(),R.layout.discover_fragment_item,null);
            viewholder=new ViewHolder(convertView);
        }else {
            viewholder= (ViewHolder) convertView.getTag();
        }
       final UsermapsBean usermaps= (UsermapsBean) getItem(position);
        viewholder.discover_item_description.setText(usermaps.getDescription());
        viewholder.discover_item_icon.setImageUrl(URL+usermaps.getHeadurl(),imageLoader);
        viewholder.discover_item_image.setImageUrl(URL+usermaps.getImageurl(),imageLoader);
            viewholder.discover_item_username.setText(usermaps.getUsername());
        Log.d(TAG, "getView: "+usermaps.getImageurl()+"Icon:"+usermaps.getIcon());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),usermaps.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    class ViewHolder{
        NetworkImageView discover_item_image;
        NetworkImageView discover_item_icon;
        TextView discover_item_username;
        TextView discover_item_description;

        public ViewHolder(View view){
            discover_item_description= (TextView) view.findViewById(R.id.discover_item_description);
            discover_item_icon= (NetworkImageView) view.findViewById(R.id.discover_item_icon);
            discover_item_image= (NetworkImageView) view.findViewById(R.id.discover_item_image);
            discover_item_username= (TextView) view.findViewById(R.id.discover_item_username);
            view.setTag(this);
        }
    }
}
