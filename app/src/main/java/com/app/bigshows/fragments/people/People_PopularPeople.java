package com.app.bigshows.fragments.people;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.people.PopularPeopleAdapter;
import com.app.bigshows.model.People.People;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.people.PopularPeopleApiInterface;
import com.app.bigshows.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 7/8/2016.
 */

public class People_PopularPeople extends Fragment {
    private RecyclerView mPopularPeopleRV;
    private PopularPeopleAdapter mPopularPeopleAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    public static final int PAGE_SIZE = 976;
    private boolean mIsLastPage = false;
    private int mCurrentPage = 1;
    private boolean mIsLoading = false;

    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_PEOPLE_FRAGMENT);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.people_popular_people, container, false);

        initViews(view);

        return view;
    }

    private void initViews(View view) {

        mPopularPeopleRV = (RecyclerView) view.findViewById(R.id.people_recyclerview);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mPopularPeopleRV.setLayoutManager(mLinearLayoutManager);
        mPopularPeopleRV.hasFixedSize();

       /* mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        mPopularPeopleRV.setLayoutManager(mStaggeredGridLayoutManager);
        mPopularPeopleRV.hasFixedSize();*/

        mPopularPeopleAdapter = new PopularPeopleAdapter();
        mPopularPeopleRV.setAdapter(mPopularPeopleAdapter);

        //pagination starts here
       /* mPopularPeopleRV.addOnScrollListener(mRecyclerViewOnScrollListener);
        PopularPeopleApiInterface mPopularPeopleApiInterface = ApiClient.getRetrofitInstance().create(PopularPeopleApiInterface.class);
        Call<People> mPeopleCall = mPopularPeopleApiInterface.getPopularPeople(Constants.API_KEY, mCurrentPage);
        mPeopleCall.enqueue(mPeopleFirstFetchCallback);*/

        mPopularPeopleRV.addOnScrollListener(mRecyclerViewOnScrollListener);
        PopularPeopleApiInterface mPopularPeopleApiInterface = ApiClient.getRetrofitInstance().create(PopularPeopleApiInterface.class);
        Call<People> mPeopleCall = mPopularPeopleApiInterface.getPopularPeople(Constants.API_KEY, mCurrentPage);
        mPeopleCall.enqueue(mPeopleFirstFetchCallback);



    }


    private RecyclerView.OnScrollListener mRecyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLinearLayoutManager.getChildCount();
            int totalItemCount = mLinearLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLinearLayoutManager.findFirstVisibleItemPosition();

            if (!mIsLoading && !mIsLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount <= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    private void loadMoreItems() {

        mIsLoading = true;
        mCurrentPage = mCurrentPage + 1;

        //create service over here
        PopularPeopleApiInterface mPopularPeopleApiInterface = ApiClient.getRetrofitInstance().create(PopularPeopleApiInterface.class);
        Call<People> mPeopleCall = mPopularPeopleApiInterface.getPopularPeople(Constants.API_KEY, mCurrentPage);
        mPeopleCall.enqueue(mPeopleNextFetchCallback);
    }


    //region for first fetch call back
    private Callback<People> mPeopleFirstFetchCallback = new Callback<People>() {
        @Override
        public void onResponse(Call<People> call, Response<People> response) {

            //mContentLoadingProgressBar.setVisibility(View.GONE);
            mIsLoading = false;
            if (response != null) {
                if (response.isSuccessful()) {
                    People mPeople = response.body();
                    if (mPeople != null) {
                        List<People.Result> results = mPeople.getResults();
                        if (results != null) {
                            mPopularPeopleAdapter.addAll(results);
                            if (results.size() >= PAGE_SIZE) {
                                mPopularPeopleAdapter.addLoading();
                            } else {
                                mIsLastPage = true;
                            }
                        }
                    }
                }
            }

        }

        @Override
        public void onFailure(Call<People> call, Throwable t) {

        }
    };



    private Callback<People> mPeopleNextFetchCallback = new Callback<People>() {
        @Override
        public void onResponse(Call<People> call, Response<People> response) {
            mPopularPeopleAdapter.removeLoading();
            mIsLoading = false;
            if (response != null) {
                if (response.isSuccessful()) {
                    People mPeople = response.body();
                    if (mPopularPeopleAdapter != null) {
                        List<People.Result> results = response.body().getResults();
                        if (results != null) {
                            mPopularPeopleAdapter.addAll(results);
                            if (results.size() > PAGE_SIZE) {
                                mPopularPeopleAdapter.addLoading();
                            } else {
                                mIsLastPage = true;
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<People> call, Throwable t) {

        }
    };

}
