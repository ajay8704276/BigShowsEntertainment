package com.app.bigshows.adapters.homepage.ontheair;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsCredits_CastWrapper;

import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

public class AiringToday_Credits_castAdpater extends RecyclerView.Adapter<AiringToday_Credits_castAdpater.CastViewHolder> {

    private List<AiringTodayTVShowsCredits_CastWrapper> mAiringTodayTVShowsCredits_castWrappers;
    private int rowLayout;
    private Context mContext;
    ImageLoader imageLoader;
    DisplayImageOptions options;


    @Override
    public AiringToday_Credits_castAdpater.CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();
        return new AiringToday_Credits_castAdpater.CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AiringToday_Credits_castAdpater.CastViewHolder holder, int position) {

        holder.mCharacterName.setText(mAiringTodayTVShowsCredits_castWrappers.get(position).getCharacter());
        holder.mOriginalName.setText(mAiringTodayTVShowsCredits_castWrappers.get(position).getName());
        imageLoader.displayImage(Constants.IMAGE_PATH + mAiringTodayTVShowsCredits_castWrappers.get(position).getProfilePath(),holder.mImageView,options);
        /*try {
            Picasso.with(mContext)
                    .load(Constants.IMAGE_PATH + mAiringTodayTVShowsCredits_castWrappers.get(position).getProfilePath())
                    .error(R.drawable.broken_image)
                    .placeholder(R.drawable.image_progress_anim)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(holder.mImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public int getItemCount() {
        return mAiringTodayTVShowsCredits_castWrappers.size();
    }

    public static class CastViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;
        private ImageView mImageView;
        private TextView mCharacterName;
        private TextView mOriginalName;


        public CastViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.airing_today_credits_crew_cardview);
            mImageView = (ImageView) itemView.findViewById(R.id.airing_today_credits_crew__images);
            mCharacterName = (TextView) itemView.findViewById(R.id.airing_today_credits_crew_character_name);
            mOriginalName = (TextView) itemView.findViewById(R.id.airing_today_credits_crew_original_name);

        }
    }


    public AiringToday_Credits_castAdpater(List<AiringTodayTVShowsCredits_CastWrapper> results, int rowLayout, Context mContext) {
        this.mAiringTodayTVShowsCredits_castWrappers = results;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}
