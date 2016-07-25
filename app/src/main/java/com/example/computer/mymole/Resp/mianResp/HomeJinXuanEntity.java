package com.example.computer.mymole.Resp.mianResp;


import com.example.computer.mymole.Resp.BaseResp;

/**
 * Created by computer on 2016/7/22.
 */
public class HomeJinXuanEntity extends BaseResp
{
  private  BannerResp[]   bannerList;
    private  RecommendResp[] recommendList;

    public BannerResp[] getBannerList() {
        return bannerList;
    }

    public void setBannerList(BannerResp[] bannerList) {
        this.bannerList = bannerList;
    }

    public RecommendResp[] getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(RecommendResp[] recommendList) {
        this.recommendList = recommendList;
    }
}
