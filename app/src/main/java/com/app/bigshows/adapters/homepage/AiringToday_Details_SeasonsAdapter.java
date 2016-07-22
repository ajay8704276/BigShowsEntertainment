package com.app.bigshows.adapters.homepage;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows_SeasonWrapper;
import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

public class AiringToday_Details_SeasonsAdapter extends RecyclerView.Adapter<AiringToday_Details_SeasonsAdapter.AiringTodayDetailViewHolder> {

    private List<AiringTodayTVShows_SeasonWrapper> mAiringTodayDetailSeasonWrapper;
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
            options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageOnLoading(R.drawable.image_progress_anim)
                    .showImageForEmptyUri(R.drawable.broken_image)
                    .showImageOnFail(R.drawable.broken_image)
                    .build();

            return new AiringTodayDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AiringTodayDetailViewHolder holder, int position) {

        holder.airDate.setText("Season Air Date - "+mAiringTodayDetailSeasonWrapper.get(position).getAirDate());
        holder.episodeCount.setText("Total Episode Count - "+mAiringTodayDetailSeasonWrapper.get(position).getEpisodeCount().toString());
        holder.seasonNumber.setText("Season NO - "+mAiringTodayDetailSeasonWrapper.get(position).getSeasonNumber().toString());

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
        TextView airDate;
        TextView episodeCount;
        TextView seasonNumber;
        ImageView imageView;
        Context mContext;

        public AiringTodayDetailViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            cardView = (CardView) itemView.findViewById(R.id.airing_today_details_cardview);
            airDate = (TextView) itemView.findViewById(R.id.airing_today_details_airdate);
            episodeCount = (TextView) itemView.findViewById(R.id.airing_today_details_episode_count);
            seasonNumber = (TextView) itemView.findViewById(R.id.airing_today_details_season_number);
            imageView = (ImageView) itemView.findViewById(R.id.airing_today_details_images);
        }

    }

    public AiringToday_Details_SeasonsAdapter(List<AiringTodayTVShows_SeasonWrapper> results, int rowLayout, Context mContext) {
        this.mAiringTodayDetailSeasonWrapper = results;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}


