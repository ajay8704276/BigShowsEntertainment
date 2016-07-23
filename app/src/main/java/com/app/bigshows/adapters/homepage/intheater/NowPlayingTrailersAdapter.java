package com.app.bigshows.adapters.homepage.intheater;

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
import com.app.bigshows.model.home.intheater.NowPlayingTrailers;
import com.app.bigshows.utils.Constants;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/23/2016.
 */

public class NowPlayingTrailersAdapter extends RecyclerView.Adapter<NowPlayingTrailersAdapter.MovieTrailersViewHolder> {

    private Context mContext;
    private List<NowPlayingTrailers.Result> results;


    @Override
    public NowPlayingTrailersAdapter.MovieTrailersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_trailers_or_videos_cardview, parent, false);
        return new MovieTrailersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NowPlayingTrailersAdapter.MovieTrailersViewHolder holder, final int position) {

        final YouTubeThumbnailLoader.OnThumbnailLoadedListener mOnThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {

                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.youtubeVideoName.setText(s);
            }

            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                Toast.makeText(mContext, "Thumbnail Initialisation Error ", Toast.LENGTH_LONG).show();
            }
        };

        holder.youTubeThumbnailView.initialize(Constants.GOOGLE_CLIENT_API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(results.get(position).getKey());
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(mOnThumbnailLoadedListener);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
                Toast.makeText(mContext, " Initialisation error ", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MovieTrailersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        public YouTubeThumbnailView youTubeThumbnailView;
        public ImageView playButton;
        public TextView youtubeVideoName;

        public MovieTrailersViewHolder(View itemView) {
            super(itemView);

            youtubeVideoName = (TextView) itemView.findViewById(R.id.youtube_video_name);
            playButton = (ImageView) itemView.findViewById(R.id.now_playing_trailers_btnYoutube_player);
            playButton.setOnClickListener(this);
            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.nowPlaying_trailers_youtube_thumbnail);
        }

        @Override
        public void onClick(View view) {
            //play you tube video based on Key Passed
            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) mContext, Constants.GOOGLE_CLIENT_API_KEY, results.get(getAdapterPosition()).getKey());
            mContext.startActivity(intent);
        }
    }


    public NowPlayingTrailersAdapter(List<NowPlayingTrailers.Result> results, Context mContext) {
        this.mContext = mContext;
        this.results = results;
    }
}
