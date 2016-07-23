package com.app.bigshows.adapters.homepage.intheater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay Kumar on 7/22/2016.
 */

public class NowPlayingDetailactivityAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    public NowPlayingDetailactivityAdapter(FragmentManager mFragmentManager){
        super(mFragmentManager);
    }



    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
    public void addFragment(Fragment fragment , String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
}
