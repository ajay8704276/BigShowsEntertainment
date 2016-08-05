package com.app.bigshows.fragments.people;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bigshows.R;

/**
 * Created by Ajay Kumar on 8/5/2016.
 */

public class PeopleKknowForFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.people_knownfor_frag,container,false);
        return view;
    }
}
