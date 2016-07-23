package com.app.bigshows.adapters.homepage.ontheair;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsCredits_CrewWrapper;
import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

public class AiringToday_Credits_crewAdapter extends RecyclerView.Adapter<AiringToday_Credits_crewAdapter.CrewViewHolder> {

    private List<AiringTodayTVShowsCredits_CrewWrapper> mAiringTodayTVShowsCreditsCrewWrappers;
    private int rowLayout;
    private Context mContext;

    ImageLoader imageLoader;
    DisplayImageOptions options;


    @Override
    public AiringToday_Credits_crewAdapter.CrewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();
        return new AiringToday_Credits_crewAdapter.CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CrewViewHolder holder, int position) {

        holder.mProducerName.setText(mAiringTodayTVShowsCreditsCrewWrappers.get(position).getName());
        holder.mDepartment.setText(mAiringTodayTVShowsCreditsCrewWrappers.get(position).getDepartment());
        holder.mJob.setText(mAiringTodayTVShowsCreditsCrewWrappers.get(position).getJob());

        imageLoader.displayImage(Constants.IMAGE_PATH + mAiringTodayTVShowsCreditsCrewWrappers.get(position).getProfilePath(),holder.mImageView,options);

       /* try {
            Picasso.with(mContext)
                    .load(Constants.IMAGE_PATH + mAiringTodayTVShowsCreditsCrewWrappers.get(position).getProfilePath())
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
        return mAiringTodayTVShowsCreditsCrewWrappers.size();
    }

    public static class CrewViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;
        private ImageView mImageView;
        private TextView mProducerName;
        private TextView mDepartment;
        private TextView mJob;


        public CrewViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.airing_today_credits_cast_cardview);
            mImageView = (ImageView) itemView.findViewById(R.id.airing_today_credits_cast__images);
            mProducerName = (TextView) itemView.findViewById(R.id.airing_today_credits_cast_producer_name);
            mDepartment = (TextView) itemView.findViewById(R.id.airing_today_credits_cast_department);
            mJob = (TextView) itemView.findViewById(R.id.airing_today_credits_cast_job);

        }
    }


    public AiringToday_Credits_crewAdapter(List<AiringTodayTVShowsCredits_CrewWrapper> results, int rowLayout, Context mContext) {
        this.mAiringTodayTVShowsCreditsCrewWrappers = results;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}

