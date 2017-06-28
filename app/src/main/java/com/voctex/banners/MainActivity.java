package com.voctex.banners;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.voctex.banner.bean.BannerEntity;
import com.voctex.banner.BannerLayout;
import com.voctex.banner.interfac.OnBannerClickListener;
import com.voctex.banner.interfac.OnBannerImgShowListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnBannerClickListener, OnBannerImgShowListener {

    private String[] imgs = {"http://i.dimg.cc/c6/83/61/ae/6d/cf/05/14/53/d0/ca/d3/b6/cc/53/a8.jpg",
            "http://cartoon.youth.cn/zxzx/201611/W020161114398226707935.jpg",
            "http://img01.cztv.com/201611/23/4b010e8135acc3f3c4c4dd6d2854396c.jpg",
            "http://fun.youth.cn/yl24xs/201609/W020160924508906880576.png",
            "http://7xsbn8.com1.z0.glb.clouddn.com/1480305147.jpg",
            "http://2t.5068.com/uploads/allimg/160406/65-1604061H216.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        BannerLayout bannerLayout = (BannerLayout) findViewById(R.id.main_bannerlayout);

        List<BannerEntity> mList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.setAdImg(imgs[i]);
            mList.add(bannerEntity);
        }

        bannerLayout.setEntities(mList,this);

        //-------------------------------------------------------------------------------------------

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


    }

    @Override
    public void onBannerClick(int position, BannerEntity bean) {
        Toast.makeText(this, "位置是：" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerShow(String url, ImageView imgView) {
        Glide.with(this)
                .load(url)
                .fitCenter()
//                        .transform(new GlideCircleTransform((Context) obj))
                .priority(Priority.NORMAL)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.pic_banner_load)
                .error(R.mipmap.pic_banner_load)
                .crossFade()
                .into(imgView);
    }
}
