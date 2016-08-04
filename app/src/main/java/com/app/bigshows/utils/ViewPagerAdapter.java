package com.app.bigshows.utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.bigshows.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Ajay Kumar on 8/2/2016.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private String[] posterPath;
    ImageLoader imageLoader;
    DisplayImageOptions options;


    public ViewPagerAdapter(Context mContext ,String[] posterPath){

        this.mContext = mContext;
        this.posterPath = posterPath;
    }

    @Override
    public int getCount() {
        return posterPath.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item,container,false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_pager_item);
        //set image resource
        imageLoader.displayImage(Constants.IMAGE_PATH +posterPath[position],imageView,options);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
