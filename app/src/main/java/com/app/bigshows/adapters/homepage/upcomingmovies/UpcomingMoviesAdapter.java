package com.app.bigshows.adapters.homepage.upcomingmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.home.upcomingmovies.UpcomingMovies;
import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay Kumar on 7/26/2016.
 */

public class UpcomingMoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM = 0;
    public static final int LOADING = 1;

    public ImageLoader imageLoader;
    public DisplayImageOptions options;

    public boolean mIsLoadingFooterAdded = false;

    public List<UpcomingMovies.Result> mUpcomingMoviesResults;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {

            case ITEM:
                viewHolder = createUpcomingMoviesViewHolder(parent);
                break;
            case LOADING:
                viewHolder = createLoadingViewHolder(parent);
                break;
        }


        return viewHolder;
    }

    private RecyclerView.ViewHolder createUpcomingMoviesViewHolder(ViewGroup parent) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_movies_cardview, parent, false);
        final UpcomingMoviesViewHolder holder = new UpcomingMoviesViewHolder(v);


        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();

        return holder;
    }

    private RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup parent) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_more, parent, false);
        final UpcomingMoviesLoadingViewHolder holder = new UpcomingMoviesLoadingViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case ITEM:
                bindUpcomingMoviesViewHolder(holder, position);
                break;
            case LOADING:
                bindLoadingViewHolder(holder, position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == mUpcomingMoviesResults.size() - 1 && mIsLoadingFooterAdded) ? LOADING : ITEM;
    }

    private void bindLoadingViewHolder(RecyclerView.ViewHolder holder, int position) {

        final UpcomingMoviesLoadingViewHolder upcomingMoviesLoadingViewHolder = (UpcomingMoviesLoadingViewHolder) holder;
        upcomingMoviesLoadingViewHolder.mLoadMoreProgressbar.setVisibility(View.VISIBLE);
    }

    private void bindUpcomingMoviesViewHolder(RecyclerView.ViewHolder holder, int position) {

        final UpcomingMoviesViewHolder upcomingMoviesViewHolder = (UpcomingMoviesViewHolder) holder;
        ((UpcomingMoviesViewHolder) holder).mUpcomingMovieTitle.setText(mUpcomingMoviesResults.get(position).getTitle());
        ((UpcomingMoviesViewHolder) holder).mUpcomingMovieRating.setText(mUpcomingMoviesResults.get(position).getVoteAverage().toString());
        ((UpcomingMoviesViewHolder) holder).mUpcomingMovieSummary.setText(mUpcomingMoviesResults.get(position).getOverview());
        ((UpcomingMoviesViewHolder) holder).mUpcomingMovieReleaseDate.setText(mUpcomingMoviesResults.get(position).getReleaseDate());
        imageLoader.displayImage(Constants.IMAGE_PATH + mUpcomingMoviesResults.get(position).getPosterPath(), ((UpcomingMoviesViewHolder) holder).mPosterIV, options);
    }

    @Override
    public int getItemCount() {
        return mUpcomingMoviesResults.size();
    }


    //create view holder for two different item
    public static class UpcomingMoviesViewHolder extends RecyclerView.ViewHolder {


        ImageView mPosterIV;
        TextView mUpcomingMovieTitle;
        TextView mUpcomingMovieRating;
        TextView mUpcomingMovieSummary;
        TextView mUpcomingMovieReleaseDate;


        public UpcomingMoviesViewHolder(View itemView) {
            super(itemView);

            mPosterIV = (ImageView) itemView.findViewById(R.id.iv_poster_image);
            mUpcomingMovieTitle = (TextView) itemView.findViewById(R.id.upcoming_movie_title);
            mUpcomingMovieRating = (TextView) itemView.findViewById(R.id.upcoming_movie_rating);
            mUpcomingMovieSummary = (TextView) itemView.findViewById(R.id.upcoming_movie_summary);
            mUpcomingMovieReleaseDate = (TextView) itemView.findViewById(R.id.upcoming_movie_release_date);
        }
    }


    public static class UpcomingMoviesLoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar mLoadMoreProgressbar;

        public UpcomingMoviesLoadingViewHolder(View itemView) {
            super(itemView);
            mLoadMoreProgressbar = (ProgressBar) itemView.findViewById(R.id.loading_iv);
        }
    }


    //Helper method for updating adapter
    // region Helper Methods
    private void add(UpcomingMovies.Result item) {
        mUpcomingMoviesResults.add(item);
        notifyItemInserted(mUpcomingMoviesResults.size() - 1);
    }

    public void addAll(List<UpcomingMovies.Result> results) {
        for (UpcomingMovies.Result result : results) {
            add(result);
        }
    }

    public void remove(UpcomingMovies.Result item) {
        int position = mUpcomingMoviesResults.indexOf(item);
        if (position > -1) {
            mUpcomingMoviesResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        mIsLoadingFooterAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoading() {
        mIsLoadingFooterAdded = true;
        add(new UpcomingMovies.Result());
    }

    public void removeLoading() {
        mIsLoadingFooterAdded = false;

        int position = mUpcomingMoviesResults.size() - 1;
        UpcomingMovies.Result item = getItem(position);

        if (item != null) {
            mUpcomingMoviesResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public UpcomingMovies.Result getItem(int position) {
        return mUpcomingMoviesResults.get(position);
    }


    public UpcomingMoviesAdapter() {

        mUpcomingMoviesResults = new ArrayList<>();
    }

}
