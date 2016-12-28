package com.voctex.banner;

import java.io.Serializable;

/**
 * Created by voctex on 20160707
 */
public class BannerEntity implements Serializable {

    private int adType;//banner的类型
    private String adImg;//图片的下载链接
    private String adTitle;//标题
    private String adUrl;//触发的链接
    private int adResId;

    public void setAdResId(int adResId) {
        this.adResId = adResId;
    }

    public int getAdResId() {
        return adResId;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

}
