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
import com.voctex.banner.interfac.IBannerEntity;
import com.voctex.banners.bean.BannerEntity;
import com.voctex.banner.BannerLayout;
import com.voctex.banner.interfac.OnBannerClickListener;
import com.voctex.banner.interfac.OnBannerImgShowListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnBannerClickListener, OnBannerImgShowListener {

    private String[] imgs = {"http://img.zcool.cn/community/0128d7579588680000012e7e04ea1b.png",
            "http://img.mp.sohu.com/upload/20170622/0413b0b8196c4dff992f23e776f222ea_th.png",
            "http://img.mp.sohu.com/upload/20170608/3071b0ecd12848ee8af6189c5be0a287_th.png",
            "http://img4.imgtn.bdimg.com/it/u=312061494,261017842&fm=26&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3067155577,1063155389&fm=214&gp=0.jpg",
            "http://img.mp.sohu.com/upload/20170622/d98f293dfbaa41a8bac4e4216a0af3b7_th.png",
            "http://img.mp.sohu.com/upload/20170622/38520b8b41a94610acabf61afc573fbe_th.png"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        BannerLayout bannerLayout = (BannerLayout) findViewById(R.id.main_bannerlayout);

        List<IBannerEntity> mList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.setAdImg(imgs[i]);
            mList.add(bannerEntity);
        }

        bannerLayout.setEntities(mList,this);

        //-------------------------------------------------------------------------------------------

        BannerLayout bannerLayout1 = (BannerLayout) findViewById(R.id.main_bannerlayout1);

        List<IBannerEntity> mList1 = new ArrayList<>();
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
    public void onBannerClick(int position, IBannerEntity bean) {
        Toast.makeText(this, "位置是：" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerShow(String url, ImageView imgView) {
        Glide.with(this)
                .load(url)
                .centerCrop()
//                        .transform(new GlideCircleTransform((Context) obj))
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.pic_banner_load)
                .error(R.mipmap.pic_banner_load)
                .crossFade()
                .into(imgView);
    }
}
