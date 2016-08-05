package com.app.bigshows.fragments.people;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bigshows.R;
import com.app.bigshows.adapters.GenericPagerFragmentAdapter;

/**
 * Created by Ajay Kumar on 8/5/2016.
 */

public class PeopleDetailBaseFragment extends Fragment implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FragmentManager mFragmentManager;
    private CardView mCardView;
    private Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.people_base_frag,container,false);

        initTab(view);

        return view;
    }

    private void initTab(View view) {

        mCardView = (CardView) view.findViewById(R.id.general_cardview);
        mToolbar = (Toolbar) view.findViewById(R.id.general_toolbar);

        mViewPager = (ViewPager) view.findViewById(R.id.general_viewpager);
        mViewPager.addOnPageChangeListener(this);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) view.findViewById(R.id.general_tab);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcon();
    }



    private void setupViewPager(ViewPager mViewPager) {

        GenericPagerFragmentAdapter mGenericPagerFragmentAdapter = new GenericPagerFragmentAdapter(mFragmentManager);
        mGenericPagerFragmentAdapter.addFragment(new PeopleBiographyFragment(),"BIOGRAPHY");
        mGenericPagerFragmentAdapter.addFragment(new PeopleKknowForFragment(),"KNOWN FOR");
        mViewPager.setAdapter(mGenericPagerFragmentAdapter);
    }


    private void setupTabIcon() {
        mTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_email);
        mTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
    }

    public PeopleDetailBaseFragment(FragmentManager mFragmentManager){
        this.mFragmentManager = mFragmentManager;

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position){
            case 0:
                mCardView.setVisibility(View.VISIBLE);
                break;
            case 1:
                mCardView.setVisibility(View.GONE);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
