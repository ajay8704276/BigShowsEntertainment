package com.app.bigshows.adapters.homepage.intheater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.activity.home.NowPlayingDetailActivity;
import com.app.bigshows.model.home.intheater.NowPlaying;
import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/22/2016.
 */

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder>{

    public static final String MOVIE_TITLE = "MOVIE_TITLE";
    private List<NowPlaying.Result> mResults ;
    private Context mContext;
    private int rowLayout;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
    public static final String MOVIEID = "MOVIEID";
    public static final String POSTER_PATH ="POSTER_PATH";

    @Override
    public NowPlayingAdapter.NowPlayingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)

                .build();
        return new NowPlayingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NowPlayingAdapter.NowPlayingViewHolder holder, final int position) {


        imageLoader.displayImage(Constants.IMAGE_PATH+mResults.get(position).getPosterPath(),holder.ivPosterImage,options);
        holder.tvMovieTitle.setText(mResults.get(position).getTitle());
        holder.tvMovieRating.setText(mResults.get(position).getVoteAverage().toString());
        holder.tvSummary.setText(mResults.get(position).getOverview());
        holder.tvMovieReleaseDate.setText(mResults.get(position).getReleaseDate());
        holder.nowPlayingCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,NowPlayingDetailActivity.class);
                intent.putExtra(MOVIEID,mResults.get(position).getId());
                intent.putExtra(POSTER_PATH,mResults.get(position).getPosterPath().toString());
                intent.putExtra(MOVIE_TITLE,mResults.get(position).getOriginalTitle());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }



    public class NowPlayingViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPosterImage;
        private TextView tvMovieTitle;
        private TextView tvMovieRating;
        private TextView tvMovieReleaseDate;
        private TextView tvSummary;
        private CardView nowPlayingCV;

        public NowPlayingViewHolder(View itemView) {
            super(itemView);

            nowPlayingCV = (CardView) itemView.findViewById(R.id.now_playing_cardview);
            ivPosterImage = (ImageView) itemView.findViewById(R.id.iv_poster_image);
            tvMovieTitle = (TextView) itemView.findViewById(R.id.tv_movie_title);
            tvMovieRating = (TextView) itemView.findViewById(R.id.tv_movie_rating);
            tvMovieReleaseDate = (TextView) itemView.findViewById(R.id.tv_movie_release_date);
            tvSummary = (TextView) itemView.findViewById(R.id.tv_movie_summary);
        }
    }


    public NowPlayingAdapter( List<NowPlaying.Result> mResults,int rowLayout,Context mContext){

        this.mResults = mResults;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}
