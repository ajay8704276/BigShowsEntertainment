package com.app.bigshows.adapters.homepage.intheater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.home.intheater.NowPlayingCreditsModel;
import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * Created by Ajay Kumar on 7/23/2016.
 */

public class NowPlayingCreditsCastAdapter extends RecyclerView.Adapter<NowPlayingCreditsCastAdapter.CastViewHolder> {

    private List<NowPlayingCreditsModel.Cast> cast ;
    private Context mContext;
    public ImageLoader imageLoader;
    public DisplayImageOptions options;

    @Override
    public NowPlayingCreditsCastAdapter.CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_credits_cast_cardview, parent, false);

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();


        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NowPlayingCreditsCastAdapter.CastViewHolder holder, int position) {

        holder.characterPlayedTV.setText(cast.get(position).getCharacter());
        holder.actorNameTV.setText(cast.get(position).getName());
        imageLoader.displayImage(Constants.IMAGE_PATH+cast.get(position).getProfilePath(),holder.mPosterIV,options);

    }

    @Override
    public int getItemCount() {
        return cast.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPosterIV;
        private TextView characterPlayedTV;
        private TextView actorNameTV;


        public CastViewHolder(View itemView) {
            super(itemView);

            mPosterIV = (ImageView) itemView.findViewById(R.id.iv_poster_image);
            characterPlayedTV = (TextView) itemView.findViewById(R.id.tv_movie_character_played);
            actorNameTV = (TextView) itemView.findViewById(R.id.tv_movie_character_name);
        }
    }

    public NowPlayingCreditsCastAdapter(List<NowPlayingCreditsModel.Cast> cast ,Context mContext){
        this.cast = cast;
        this.mContext = mContext;
    }
}
