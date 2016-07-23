package com.app.bigshows.adapters.homepage.ontheair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.bigshows.R;
import com.app.bigshows.model.home.tvshows.AirinTodayTVShowsSimilar_TVVideos_ResultWrapper;
import com.app.bigshows.utils.Constants;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/14/2016.
 */

public class AiringToday_Similar_TVVideosAdapter  extends RecyclerView.Adapter<AiringToday_Similar_TVVideosAdapter.TVVideosCardViewHolder>{


    public List<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper> mAirinTodayTVShowsSimilar_tvVideos_resultWrappers;
    private int rowLayout;
    public static Context mContext;



    @Override
    public TVVideosCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AiringToday_Similar_TVVideosAdapter.TVVideosCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TVVideosCardViewHolder holder, final int position) {

        final YouTubeThumbnailLoader.OnThumbnailLoadedListener mOnThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {

                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.youtubeVideoName.setText(s);
            }

            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                Toast.makeText(mContext,"Thumbnail Initialisation Error ",Toast.LENGTH_LONG).show();
            }
        };

        holder.youTubeThumbnailView.initialize(Constants.GOOGLE_CLIENT_API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(mAirinTodayTVShowsSimilar_tvVideos_resultWrappers.get(position).getKey());
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(mOnThumbnailLoadedListener);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
                Toast.makeText(mContext," Initialisation error ",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAirinTodayTVShowsSimilar_tvVideos_resultWrappers.size();
    }

    public class TVVideosCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        public YouTubeThumbnailView youTubeThumbnailView;
        public ImageView playButton;
        public TextView youtubeVideoName;

        public TVVideosCardViewHolder(View itemView) {
            super(itemView);

            youtubeVideoName = (TextView) itemView.findViewById(R.id.youtube_video_name);
            playButton=(ImageView)itemView.findViewById(R.id.airing_today_similar_tvvideos_btnYoutube_player);
            playButton.setOnClickListener(this);
            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.airing_today_similar_tvvideos_youtube_thumbnail);
        }

        @Override
        public void onClick(View view) {
            // do something

            //play you tube video based on Key Passed
            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) mContext, Constants.GOOGLE_CLIENT_API_KEY, mAirinTodayTVShowsSimilar_tvVideos_resultWrappers.get(getAdapterPosition()).getKey());
            mContext.startActivity(intent);
        }
    }


    public AiringToday_Similar_TVVideosAdapter(List<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper> results, int rowLayout, Context mContext) {
        this.mAirinTodayTVShowsSimilar_tvVideos_resultWrappers = results;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}
