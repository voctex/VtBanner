package com.voctex.banner;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by voctex on 2016/7/22.
 * banner的适配器
 */
public class BannerAdapter extends PagerAdapter {

    /**
     * 装ImageView数组
     */
    private List<ImageView> imgList = new ArrayList<>();
    private OnBannerClickListener onBannerClickListener;

    public BannerAdapter(Context mContext, final List<BannerEntity> mlist) {
        imgList.clear();
        for (int i = 0; i < mlist.size(); i++) {
            BannerEntity entity = mlist.get(i);
            final int position = i;
            ImageView img = new ImageView(mContext);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onBannerClickListener != null) {
                        onBannerClickListener.onBannerClick(position - 1, mlist.get(position));
                    }
                }
            });
            if (entity.getAdImg() == null) {
                img.setImageResource(entity.getAdResId());
            } else {
//                ImgUtil.showBanner(mContext, img, mlist.get(i).getAdImg());

                Glide.with(mContext)
                        .load(entity.getAdImg())
                        .fitCenter()
//                        .transform(new GlideCircleTransform((Context) obj))
                        .priority(Priority.NORMAL)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .placeholder(R.mipmap.pic_banner_load)
                        .error(R.mipmap.pic_banner_load)
                        .crossFade()
                        .into(img);

            }
            imgList.add(img);
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imgList.get(position));

    }

    /**
     * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img = imgList.get(position);
        container.addView(img);
        return imgList.get(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }


    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    void setOnBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.onBannerClickListener = onBannerClickListener;
    }
}
