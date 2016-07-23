/*
package com.app.bigshows.adapters.homepage.intheater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.home.intheater.NowPlayingMovieDetails;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

*/
/**
 * Created by Ajay Kumar on 7/23/2016.
 *//*


public class NowPlayingMovieDetailsAdapter extends RecyclerView.Adapter<NowPlayingMovieDetailsAdapter.MovieDetailViewHolder> {

    private List<NowPlayingMovieDetails> movieDetails;
    private Context mContext;
    public ImageLoader imageLoader;
    public DisplayImageOptions options;

    @Override
    public NowPlayingMovieDetailsAdapter.MovieDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_movie_details, parent, false);

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();


        return new MovieDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NowPlayingMovieDetailsAdapter.MovieDetailViewHolder holder, int position) {

        StringBuilder stringBuilder = new StringBuilder();
        if(movieDetails!=null){
            for(int i=0 ; i<movieDetails.get(position).getGenres().size() ;i++){
                stringBuilder.append(movieDetails.get(position).getGenres().get(i).getName());
                if(i!= movieDetails.get(position).getGenres().size()){
                    stringBuilder.append(",");
                }
            }
        }
        holder.titleTV.setText(movieDetails.get(position).getTitle());
        holder.genresTV.setText(stringBuilder.toString());
        holder.descriptionTV.setText(movieDetails.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movieDetails.size();
    }

    public class MovieDetailViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTV;
        private TextView genresTV;
        private TextView descriptionTV;

        public MovieDetailViewHolder(View itemView) {
            super(itemView);

            titleTV = (TextView) itemView.findViewById(R.id.tv_title);
            genresTV = (TextView) itemView.findViewById(R.id.tv_genres);
            descriptionTV = (TextView) itemView.findViewById(R.id.tv_description);
        }
    }

    public NowPlayingMovieDetailsAdapter(List<NowPlayingMovieDetails> movieDetails,Context mContext){
        this.movieDetails = movieDetails;
        this.mContext = mContext;
    }
}
*/
