package com.example.computer.mymole.Resp.mianResp;

/**
 * Created by computer on 2016/7/22.
 */
public class BannerResp {
    /** 9*/private int action;
    /** 223196*/private int args;
    /** 一景一席谈，与你畅谈中外景点背后最有*/private String description;
    /** http://image.xunjimap.com/image/cms/impress/bbee0cfc-938f-4092-a89e-9d3e698aa619.jpg*/private String imageurl;
    /** 一景一席谈*/private String name;
    /** 2063*/private int topicitemid;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getArgs() {
        return args;
    }

    public void setArgs(int args) {
        this.args = args;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTopicitemid() {
        return topicitemid;
    }

    public void setTopicitemid(int topicitemid) {
        this.topicitemid = topicitemid;
    }

    @Override
    public String toString() {
        return "BannerResp{" +
                "action=" + action +
                ", args=" + args +
                ", description='" + description + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", name='" + name + '\'' +
                ", topicitemid=" + topicitemid +
                '}';
    }
}
