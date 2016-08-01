package com.example.computer.mymole.Resp.Discover;

import com.example.computer.mymole.Resp.BaseResp;

/**
 * Created by computer on 2016/7/27.
 */
public class DiscoverResp  extends BaseResp{
    private UsermapsBean[] usermaps;

    public UsermapsBean[] getUsermaps() {
        return usermaps;
    }

    public void setUsermaps(UsermapsBean[] usermaps) {
        this.usermaps = usermaps;
    }
}
