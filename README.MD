# VtBanner
实现广告无限轮播效果，滑动畅顺，还解决了一些嵌套的问题

####安装说明：
Gradle:
```
compile 'com.voctex.banner:banner:1.0.7'
```

Maven:
```
<dependency>
  <groupId>com.voctex.banner</groupId>
  <artifactId>banner</artifactId>
  <version>1.0.7</version>
  <type>pom</type>
</dependency>
```


先看看下面的示意图：

![Image text](https://github.com/voctex/VtBanner/blob/master/gif/banners.gif?raw=true)

可直接放置在xml布局文件中
```
            <com.voctex.banner.BannerLayout
                android:id="@+id/main_bannerlayout"
                android:layout_width="match_parent"
                android:layout_height="180dp">
            </com.voctex.banner.BannerLayout>
```

##### 有以下功能：

1、可手动滑动；

2、可自己设置定时滑动；

3、实现真正的无限轮播；

4、可改变点的位置以及颜色；

5、可设置资源图片，然后显示；(可自己设置显示)

6、移除底层用Glide框架加载图片，可自己选择图片加载框架；

7、自定义bean类，实现IBannerEntity接口即可；



##### 自定义javabean类：（注意注释的地方）
```
public class BannerEntity implements Serializable,IBannerEntity {

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

    @Override
    public String getBannerImgUrlStr() {
        //主要是返回图片的url字符串数据，才可显示
        return adImg;
    }
}
```

##### 设置数据代码如下：

```
        BannerLayout bannerLayout1 = (BannerLayout) findViewById(R.id.main_bannerlayout1);

        List<BannerEntity> mList1 = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.setAdImg(imgs[i]);
            mList1.add(bannerEntity);
        }

        bannerLayout1.setEntities(mList1,this);
        //这里设置点的颜色和位置需要设置了数据之后才能设置，因为点的数量需要数据的条数来确定
        bannerLayout1.setPointColor(Color.BLUE, Color.RED);
        bannerLayout1.setPointPotision(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        //设置无限轮播的起始停顿时间和轮播的间隔时间
        bannerLayout1.schedule(2000, 3000);
        //设置轮播的点击事件
        bannerLayout1.setOnBannerClickListener(this);
```

#### 总结
已解决库里面依赖的javabean类，通过抽象成接口的形式，使用者自定义bean类，实现IBannerEntity接口，
实现方法getBannerImgUrlStr()，返回显示图片的url字符串数据即可显示.


#### v1.0.7
抽象库里面的bean类，使其成为接口的形式让使用者自定义bean类

#### v1.0.5
对OnBannerImgShowListener的回调进行优化

#### v1.0.1
移除底层用Glide加载图片框架，改为用接口回调到最上层，由调用者自己选择图片加载框架自己配置

#### v1.0.0
首次更新，后期会根据情况慢慢优化
