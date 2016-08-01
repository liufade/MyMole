package com.example.computer.mymole.Resp.Discover;

import java.io.Serializable;

/**
 * Created by computer on 2016/7/27.
 */
public class UsermapsBean implements Serializable{
    /** 951*/private int attitudecount;
    /** 1450627200000*/private long createdate;
    /** 文章*/private String description;
    /** cms/story/f5a9d4d6-6419-4d1e-9cab-0db8467a9339.jpg*/private String headurl;
    /** cms/impress/3735a5ce-441b-47bb-a8c8-f33cb14580fc.png*/private String icon;
    /** cms/impress/38703625-bd31-45c1-b716-6e6db7d23877.jpg*/private String imageurl;
    /** 0*/private int isprivate;
    /** 其他*/private String label;
    /** 1*/private int status;
    /** 9*/private int storycount;
    /** 与袁腾飞游古战场*/private String title;
    /** 1*/private int type;
    /** 1456815357000*/private long updatedate;
    /** Array*/private String userInfos;
    /** 1*/private int userinfoid;
    /** 205651*/private int usermapid;
    /** 袁腾飞*/private String username;

    public int getAttitudecount() {
        return attitudecount;
    }

    public void setAttitudecount(int attitudecount) {
        this.attitudecount = attitudecount;
    }


    public long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(long createdate) {
        this.createdate = createdate;
    }

    public long getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(long updatedate) {
        this.updatedate = updatedate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }



    public int getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(int userinfoid) {
        this.userinfoid = userinfoid;
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
        return "UsermapsBean{" +
                "attitudecount=" + attitudecount +
                ", createdate=" + createdate +
                ", description='" + description + '\'' +
                ", headurl='" + headurl + '\'' +
                ", icon='" + icon + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", isprivate=" + isprivate +
                ", label='" + label + '\'' +
                ", status=" + status +
                ", storycount=" + storycount +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", updatedate=" + updatedate +
                ", userInfos='" + userInfos + '\'' +
                ", userinfoid=" + userinfoid +
                ", usermapid=" + usermapid +
                ", username='" + username + '\'' +
                '}';
    }
}
