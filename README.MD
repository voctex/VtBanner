# VtBanner
实现无限轮播效果，滑动畅顺，还解决了一些嵌套的问题

####安装说明：
Gradle:
~~~
compile 'com.voctex.banner:banner:1.0.0'
~~~

Maven:
~~~
<dependency>
  <groupId>com.voctex.banner</groupId>
  <artifactId>banner</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
~~~


先看看下面的示意图：

![Image text](https://github.com/voctex/VtBanner/blob/master/gif/banners.gif?raw=true)

可直接放置在xml布局文件中
~~~~
            <com.voctex.banner.BannerLayout
                android:id="@+id/main_bannerlayout"
                android:layout_width="match_parent"
                android:layout_height="180dp">
            </com.voctex.banner.BannerLayout>
~~~~

有以下功能：

1、可手动滑动；

2、可自己设置定时滑动；

3、实现真正的无限轮播；

4、可改变点的位置以及颜色；

5、可设置资源图片，然后显示


设置数据代码如下：

~~~
        BannerLayout bannerLayout1 = (BannerLayout) findViewById(R.id.main_bannerlayout1);

        List<BannerEntity> mList1 = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.setAdImg(imgs[i]);
            mList1.add(bannerEntity);
        }

        bannerLayout1.setEntities(mList1);
        //这里设置点的颜色和位置需要设置了数据之后才能设置，因为点的数量需要数据的条数来确定
        bannerLayout1.setPointColor(Color.BLUE, Color.RED);
        bannerLayout1.setPointPotision(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        //设置无限轮播的起始停顿时间和轮播的间隔时间
        bannerLayout1.schedule(2000, 3000);
        //设置轮播的点击事件
        bannerLayout1.setOnBannerClickListener(this);
~~~

暂时是以module的形式引进来的，后期会改成封装成aar上传到git远程仓库，不过现在以library的形式的话，你们也好方便改代码



###v1.0.0
首次更新
