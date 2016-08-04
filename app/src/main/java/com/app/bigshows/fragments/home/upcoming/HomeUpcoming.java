package com.app.bigshows.fragments.home.upcoming;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.upcomingmovies.UpcomingMoviesAdapter;
import com.app.bigshows.model.home.upcomingmovies.UpcomingMovies;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.home.UpcomingMoviesInterface;
import com.app.bigshows.utils.Constants;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 7/9/2016.
 */

public class HomeUpcoming extends Fragment {

    public static final int PAGE_SIZE = 6;
    private boolean mIsLastPage = false;
    private int mCurrentPage = 1;
    private boolean mIsLoading = false;
    private UpcomingMoviesAdapter mUpcomingMoviesAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mUpcomingMoviesRecyclerView;
    private ContentLoadingProgressBar mContentLoadingProgressBar;



    // Empty constructor required
    public HomeUpcoming(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_upcoming_movies,container,false);

        initView(view);

        return view;
    }

    private void initView(View view) {

        mLayoutManager = new LinearLayoutManager(getContext());
        mUpcomingMoviesRecyclerView = (RecyclerView) view.findViewById(R.id.upcoming_movies_rv);
        mUpcomingMoviesRecyclerView.setLayoutManager(mLayoutManager);

        mUpcomingMoviesAdapter = new UpcomingMoviesAdapter();
        mUpcomingMoviesRecyclerView.setAdapter(mUpcomingMoviesAdapter);


        //pagination starts here
        mUpcomingMoviesRecyclerView.addOnScrollListener(mRecyclerViewOnScrollListener);

        UpcomingMoviesInterface mUpcomingMoviesInterface = ApiClient.getRetrofitInstance().create(UpcomingMoviesInterface.class);
        Call<UpcomingMovies> mUpcomingMoviesCall = mUpcomingMoviesInterface.getUpcomingMovies(Constants.API_KEY,mCurrentPage);
        mUpcomingMoviesCall.enqueue(mUpcomingMoviesFirstFetchCallback);

        //mContentLoadingProgressBar = (ContentLoadingProgressBar) view.findViewById(R.id.upcoming_movies_progressbar);


    }


    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_HOME_TRAILERS);
    }


    //Listener
    private RecyclerView.OnScrollListener mRecyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

            if (!mIsLoading && !mIsLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    private void loadMoreItems() {

        mIsLoading = true;
        mCurrentPage = mCurrentPage+1;

        //create service over here
        UpcomingMoviesInterface mUpcomingMoviesInterface = ApiClient.getRetrofitInstance().create(UpcomingMoviesInterface.class);

        Call<UpcomingMovies> mUpcomingMoviesCall = mUpcomingMoviesInterface.getUpcomingMovies(Constants.API_KEY,mCurrentPage);
        mUpcomingMoviesCall.enqueue(mUpcomingMoviesNextFetchCallback);
    }

    //region for first fetch call back
    private Callback<UpcomingMovies> mUpcomingMoviesFirstFetchCallback = new Callback<UpcomingMovies>() {
        @Override
        public void onResponse(Call<UpcomingMovies> call, Response<UpcomingMovies> response) {

            //mContentLoadingProgressBar.setVisibility(View.GONE);
            mIsLoading = false;
            if(response!= null){
                if(response.isSuccessful()){
                    UpcomingMovies upcomingMovies = response.body();
                    if(upcomingMovies!=null){
                        List<UpcomingMovies.Result> results = upcomingMovies.getResults();
                        if(results!=null){
                            mUpcomingMoviesAdapter.addAll(results);
                            if(results.size()>=PAGE_SIZE){
                                mUpcomingMoviesAdapter.addLoading();
                            }else{
                                mIsLastPage = true;
                            }
                        }
                    }
                }
            }

        }

        @Override
        public void onFailure(Call<UpcomingMovies> call, Throwable t) {

            //Toast.makeText(getContext(),t.getMessage().toString(),Toast.LENGTH_LONG).show();

        }
    };


    private Callback<UpcomingMovies> mUpcomingMoviesNextFetchCallback = new Callback<UpcomingMovies>() {
        @Override
        public void onResponse(Call<UpcomingMovies> call, Response<UpcomingMovies> response) {
            mUpcomingMoviesAdapter.removeLoading();
            mIsLoading = false;
            if(response!=null){
                if(response.isSuccessful()){
                    UpcomingMovies mUpcomingMovies = response.body();
                    if(mUpcomingMovies!=null){
                        List<UpcomingMovies.Result> results = response.body().getResults();
                        if(results!=null){
                            mUpcomingMoviesAdapter.addAll(results);
                            if(results.size()>PAGE_SIZE){
                                mUpcomingMoviesAdapter.addLoading();
                            }else{
                                mIsLastPage = true;
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<UpcomingMovies> call, Throwable t) {

        }
    };
}
