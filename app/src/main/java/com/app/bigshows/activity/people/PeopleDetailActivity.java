package com.app.bigshows.activity.people;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.bigshows.R;
import com.app.bigshows.fragments.people.PeopleDetailBaseFragment;

/**
 * Created by Ajay Kumar on 8/5/2016.
 */

public class PeopleDetailActivity extends AppCompatActivity {

    PeopleDetailBaseFragment mPeopleDetailBaseFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        initialiseFragment();
       /* if (getIntent().getExtras() != null) {
            int personID = getIntent().getExtras().getInt();
            fragment initialisation
            initialiseFragment(personID);

        }*/


    }

    private void initialiseFragment() {
        mPeopleDetailBaseFragment = new PeopleDetailBaseFragment(getSupportFragmentManager());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.base_fragment_container, mPeopleDetailBaseFragment)
                .addToBackStack(null)
                .commit();
        //create service request
        //startPeopleDetailServiceRequest(personID);
    }

    private void startPeopleDetailServiceRequest(int personID) {


    }
}
