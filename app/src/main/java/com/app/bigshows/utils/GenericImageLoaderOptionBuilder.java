package com.app.bigshows.utils;

import android.graphics.Bitmap;

import com.app.bigshows.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

/**
 * Created by Ajay Kumar on 8/5/2016.
 */

public class GenericImageLoaderOptionBuilder {

    private static DisplayImageOptions options;

    public static DisplayImageOptions getOptions() {

        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .postProcessor(new BitmapProcessor() {
                    @Override
                    public Bitmap process(Bitmap bmp) {
                        return Bitmap.createScaledBitmap(bmp, 200, 300, false);
                    }
                })
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();

        return options;
    }
}
