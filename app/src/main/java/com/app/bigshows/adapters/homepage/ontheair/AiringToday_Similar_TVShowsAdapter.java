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
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsSimilar_TVShows_ResultWrapper;
import com.app.bigshows.utils.Constants;
import com.app.bigshows.utils.GenericImageLoaderOptionBuilder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/14/2016.
 */

public class AiringToday_Similar_TVShowsAdapter extends RecyclerView.Adapter<AiringToday_Similar_TVShowsAdapter.TVShowsCardViewHolder> {


    private List<AiringTodayTVShowsSimilar_TVShows_ResultWrapper> mAiringTodayTVShowsSimilar_tvShows_resultWrappers;
    private Context mContext;
    private int rowLayout;

    private String imagePath ;
    ImageLoader imageLoader;
    DisplayImageOptions options;


    @Override
    public AiringToday_Similar_TVShowsAdapter.TVShowsCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);

        imageLoader = ImageLoader.getInstance();
        options = GenericImageLoaderOptionBuilder.getOptions();

        return new AiringToday_Similar_TVShowsAdapter.TVShowsCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AiringToday_Similar_TVShowsAdapter.TVShowsCardViewHolder holder, int position) {

        holder.mShowName.setText(mAiringTodayTVShowsSimilar_tvShows_resultWrappers.get(position).getName());
        holder.mVoteAVG.setText(mAiringTodayTVShowsSimilar_tvShows_resultWrappers.get(position).getPopularity().toString());
        String mPosterPathObject = mAiringTodayTVShowsSimilar_tvShows_resultWrappers.get(position).getPosterPath();
        String mBackdropPathObject =mAiringTodayTVShowsSimilar_tvShows_resultWrappers.get(position).getBackdropPath();
        if(mPosterPathObject!=null && mBackdropPathObject!=null){
            imagePath = mPosterPathObject;
        }else if(mBackdropPathObject == null && mPosterPathObject ==null){
            imagePath = null;
        }else if(mBackdropPathObject !=null && mPosterPathObject ==null){
            imagePath = mBackdropPathObject;
        }else if(mPosterPathObject != null && mBackdropPathObject == null){
            imagePath = mPosterPathObject;
        }

        imageLoader.displayImage(Constants.IMAGE_PATH + imagePath,holder.mImageView,options);
       /* try {
            Picasso.with(mContext)
                    .load(Constants.IMAGE_PATH + mAiringTodayTVShowsSimilar_tvShows_resultWrappers.get(position).getBackdropPath())
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
        return mAiringTodayTVShowsSimilar_tvShows_resultWrappers.size();
    }

    public class TVShowsCardViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;
        private ImageView mImageView;
        private TextView mShowName;
        private TextView mVoteAVG;


        public TVShowsCardViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.airing_today_similar_tvshows_cardview);
            mImageView = (ImageView) itemView.findViewById(R.id.airing_today_similar_tvshows__images);
            mShowName = (TextView) itemView.findViewById(R.id.airing_today_similar_show_name);
            mVoteAVG = (TextView) itemView.findViewById(R.id.airing_today_similar_tvshows_rating);


        }
    }


    public AiringToday_Similar_TVShowsAdapter(List<AiringTodayTVShowsSimilar_TVShows_ResultWrapper> results, int rowLayout, Context mContext) {
        this.mAiringTodayTVShowsSimilar_tvShows_resultWrappers = results;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}
