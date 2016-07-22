package com.app.bigshows.tracker;

import android.content.Context;

import com.app.bigshows.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ajay Kumar on 7/18/2016.
 */

public final class BigShowsAppTracker {

    private static BigShowsAppTracker sInstance;
    private final Context mContext;

    public BigShowsAppTracker(Context mContext) {
        this.mContext = mContext.getApplicationContext();
    }

    public enum Target{
        APP,
        //add more tracker if we need but for now this only
    }


    public static synchronized void initialize(Context mContext){
        if(sInstance!=null){
            throw new IllegalStateException("Extra call to initialize google analytics tracker");
        }
        sInstance = new BigShowsAppTracker(mContext);
    }


    public static synchronized  BigShowsAppTracker getInstance(){
        if(sInstance == null){
            throw new IllegalStateException("Call initialise before getInstance");
        }
        return sInstance;
    }

    private final Map<Target, Tracker> mTrackers = new HashMap<Target, Tracker>();

    public synchronized Tracker getTracker(Target target){
        if(!mTrackers.containsKey(target)){
            Tracker tracker ;
            switch (target){

                case APP :
                    tracker = GoogleAnalytics.getInstance(mContext).newTracker(R.xml.app_tracker);
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled analytics target " + target);
            }

            mTrackers.put(target,tracker);
        }

        return mTrackers.get(target);
    }
}
