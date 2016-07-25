package com.example.computer.mymole.Resp.mianResp;

import java.io.Serializable;

/**
 * Created by computer on 2016/7/22.
 */
public class RecommendResp extends HomeJinXuanEntity implements Serializable{
    /** 36*/private int attitudecount;
    /** cms/story/441d5525-53c8-41c0-aaea-f8a4820daf62.jpg*/private String headurl;
    /** cms/impress/b49a611d-945d-47b0-964b-ac3dac3b5669.png*/private String icon;
    /** cms/topic/ea24c098-a2c0-40dd-8991-2d425a6db0e7.jpg*/private String imageurl;
    /** 1*/private int isprivate;
    /** 其他*/private String label;
    /** 1*/private int status;
    /** 15*/private int storycount;
    /** 边陲小镇的真面目*/private String title;
    /** 在广袤的天朝疆土上。。。*/private String topicDescription;
    /** Array*/private String userInfos;
    /** 35294*/private int userinfoid;
    /** 205724*/private int usermapid;
    /** 老人与海明威*/private String username;

    public int getAttitudecount() {
        return attitudecount;
    }

    public void setAttitudecount(int attitudecount) {
        this.attitudecount = attitudecount;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(int isprivate) {
        this.isprivate = isprivate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStorycount() {
        return storycount;
    }

    public void setStorycount(int storycount) {
        this.storycount = storycount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(int userinfoid) {
        this.userinfoid = userinfoid;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public String getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(String userInfos) {
        this.userInfos = userInfos;
    }

    public int getUsermapid() {
        return usermapid;
    }

    public void setUsermapid(int usermapid) {
        this.usermapid = usermapid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RecommendResp{" +
                "attitudecount=" + attitudecount +
                ", headurl='" + headurl + '\'' +
                ", icon='" + icon + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", isprivate=" + isprivate +
                ", label='" + label + '\'' +
                ", status=" + status +
                ", storycount=" + storycount +
                ", title='" + title + '\'' +
                ", topicDescription='" + topicDescription + '\'' +
                ", userInfos='" + userInfos + '\'' +
                ", userinfoid=" + userinfoid +
                ", usermapid=" + usermapid +
                ", username='" + username + '\'' +
                '}';
    }
}
