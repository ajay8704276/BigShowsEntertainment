package com.app.bigshows.activity.people;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.fragments.people.People_PopularPeople;
import com.app.bigshows.utils.Constants;

/**
 * Created by Ajay Kumar on 7/8/2016.
 */

public class PeopleActivity  extends AppCompatActivity {



    private Toolbar peopleToolbar;
    private People_PopularPeople mPeople_popularPeople;
    private FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.people);
        //
        // mPeople_popularPeople = new People_PopularPeople();

        peopleToolbar = (Toolbar) findViewById(R.id.people_toolbar);
        setSupportActionBar(peopleToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.people_container,mPeople_popularPeople);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_PEOPLE);
    }

}
