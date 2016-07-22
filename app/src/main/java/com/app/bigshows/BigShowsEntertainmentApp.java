package com.app.bigshows;

import android.app.Application;


import com.app.bigshows.tracker.BigShowsAppTracker;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.Map;

/**
 * Created by Ajay Kumar on 6/30/2016.
 *
 */

public class BigShowsEntertainmentApp extends Application {



    private Tracker mTracker;

    private static BigShowsEntertainmentApp mSingleInstance ;

    private  String validSessionID = null;

    private boolean isValidTMDBSession;

    private boolean isUserLoggedIN;

    private boolean isUserLoggedOUT;

    public String getValidSessionID() {
        return validSessionID;
    }

    public void setValidSessionID(String validSessionID) {
        this.validSessionID = validSessionID;
    }
    public boolean isValidTMDBSession() {
        return isValidTMDBSession;
    }

    public void setValidTMDBSession(boolean validTMDBSession) {
        isValidTMDBSession = validTMDBSession;
    }

    public boolean isUserLoggedIN() {
        return isUserLoggedIN;
    }

    public void setUserLoggedIN(boolean userLoggedIN) {
        isUserLoggedIN = userLoggedIN;
    }

    public boolean isUserLoggedOUT() {
        return isUserLoggedOUT;
    }

    public void setUserLoggedOUT(boolean userLoggedOUT) {
        isUserLoggedOUT = userLoggedOUT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSingleInstance = this;

        //initialise google analytics tracker
        BigShowsAppTracker.initialize(this);
        BigShowsAppTracker.getInstance().getTracker(BigShowsAppTracker.Target.APP);


        /*//initialise piccasso library
        Picasso.Builder mPicassoBuilder = new Picasso.Builder(this);
        //mPicassoBuilder.downloader(new OkHttpDownloader(this,Integer.MAX_VALUE));

        Picasso built = mPicassoBuilder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        //setting singleton for picasso
        Picasso.setSingletonInstance(built);
*/

        // initialise image loader
        initializeUniversalImageLoader();

    }

    /**
     * Common initialisation for Universal image loader provided by google
     */
    private void initializeUniversalImageLoader() {

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }

    /**
     *
     * @return singleton instance of App
     */
    public static synchronized BigShowsEntertainmentApp getSingleInstance() {
        return mSingleInstance;
    }


    /**
     *
     * @return Google analytics Tracker
     */
    public synchronized Tracker getGoogleAnalyticsTracker(){
        BigShowsAppTracker mBigShowsAppTracker = BigShowsAppTracker.getInstance();
        return mBigShowsAppTracker.getTracker(BigShowsAppTracker.Target.APP);
    }


    /**
     * Tracking screen view
     * @param screenName Name of the screen to be displayed on google dash board
     */
    public void trackScreenView(String screenName){

        Tracker tracker = getGoogleAnalyticsTracker();

        //setting screen  name
        tracker.setScreenName(screenName);

        //sending screen view
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
        GoogleAnalytics.getInstance(this).dispatchLocalHits();
    }


    /**
     * Tracking events
     * @param category category
     * @param action action type
     * @param label button label
     */
    public void trackEvents(String category, String action ,String label){

        Tracker tracker = getGoogleAnalyticsTracker();

        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .build());
    }

    /**
     * Exception Tracking
     * @param e exception to be tracked
     */
    public void trackException(Exception e){

        if(e!=null){
            Tracker tracker = getGoogleAnalyticsTracker();
            tracker.send(new HitBuilders.ExceptionBuilder()
            .setDescription(new StandardExceptionParser(this,null).getDescription(Thread.currentThread().getName(),e))
            .setFatal(false)
            .build());

        }
    }
}
