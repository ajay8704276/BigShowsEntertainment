package com.app.bigshows.adapters.homepage.ontheair;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows_SeasonWrapper;
import com.app.bigshows.utils.Constants;
import com.app.bigshows.utils.GenericImageLoaderOptionBuilder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

public class AiringToday_Details_SeasonsAdapter extends RecyclerView.Adapter<AiringToday_Details_SeasonsAdapter.AiringTodayDetailViewHolder> {

    private List<AiringTodayTVShows_SeasonWrapper> mAiringTodayDetailSeasonWrapper;
    private AiringTodayTVShows mAiringTodayTVShows;
    private StringBuilder mGenreStringBuilder;
    private StringBuilder mRuntimeStringBuilder;
    private int rowLayout;
    private Context mContext;
    ImageLoader imageLoader;
    DisplayImageOptions options;
    private final int AD_TYPE = 1;
    private final int CONTENT_TYPE = 2;

    @Override
    public AiringTodayDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
            imageLoader = ImageLoader.getInstance();
            options = GenericImageLoaderOptionBuilder.getOptions();
            return new AiringTodayDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AiringTodayDetailViewHolder holder, int position) {


        holder.title.setText(mAiringTodayTVShows.getName());
        holder.genre.setText(mGenreStringBuilder);
        holder.runtime.setText(mRuntimeStringBuilder);
        holder.runtime.setVisibility(View.GONE);
        holder.airDate.setText(mAiringTodayDetailSeasonWrapper.get(position).getAirDate());
        holder.episodeCount.setText(mAiringTodayDetailSeasonWrapper.get(position).getEpisodeCount().toString());
        holder.seasonNumber.setText(mAiringTodayDetailSeasonWrapper.get(position).getSeasonNumber().toString());

        imageLoader.displayImage(Constants.IMAGE_PATH + mAiringTodayDetailSeasonWrapper.get(position).getPosterPath(),holder.imageView,options);
        /*try {
            Picasso.with(mContext)
                    .load(Constants.IMAGE_PATH + mAiringTodayDetailSeasonWrapper.get(position).getPosterPath())
                    .error(R.drawable.broken_image)
                    .placeholder(R.drawable.image_progress_anim)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }


    @Override
    public int getItemCount() {
        return mAiringTodayDetailSeasonWrapper.size();
    }

    public static class AiringTodayDetailViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        TextView genre;
        TextView runtime;
        TextView airDate;
        TextView episodeCount;
        TextView seasonNumber;
        ImageView imageView;
        Context mContext;

        public AiringTodayDetailViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            cardView = (CardView) itemView.findViewById(R.id.airing_today_detail_season_cardview);
            title = (TextView) itemView.findViewById(R.id.tv_movie_title);
            genre = (TextView) itemView.findViewById(R.id.tv_movie_genre);
            runtime = (TextView) itemView.findViewById(R.id.tv_movie_runtime);
            airDate = (TextView) itemView.findViewById(R.id.tv_movie_air_date);
            episodeCount = (TextView) itemView.findViewById(R.id.tv_movie_episode_count);
            seasonNumber = (TextView) itemView.findViewById(R.id.tv_movie_season_no);
            imageView = (ImageView) itemView.findViewById(R.id.iv_poster_image);
        }

    }

    public AiringToday_Details_SeasonsAdapter(List<AiringTodayTVShows_SeasonWrapper> results, AiringTodayTVShows mAiringTodayTVShows, int rowLayout, Context mContext) {
        this.mAiringTodayDetailSeasonWrapper = results;
        this.mAiringTodayTVShows = mAiringTodayTVShows;
        int genreCount = mAiringTodayTVShows.getGenres().size();

        mGenreStringBuilder = new StringBuilder();
        for(int x=0;x<=genreCount;x++){

            if(x!=genreCount){
                mGenreStringBuilder.append(mAiringTodayTVShows.getGenres().get(x).getName());
                if(x==genreCount) {
                    mGenreStringBuilder.append(" ");
                }else{
                    mGenreStringBuilder.append(",");
                }
            }
        }


        int runtimeCount = mAiringTodayTVShows.getEpisodeRunTime().size();
        mRuntimeStringBuilder = new StringBuilder();
        for(int p=0 ;p<=runtimeCount;p++){

            if(p!=runtimeCount){
                mRuntimeStringBuilder.append(mAiringTodayTVShows.getEpisodeRunTime().get(p));
                mRuntimeStringBuilder.append(",");
            }
        }
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}


