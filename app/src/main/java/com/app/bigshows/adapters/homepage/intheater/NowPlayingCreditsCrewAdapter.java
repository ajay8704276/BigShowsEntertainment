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

public class NowPlayingCreditsCrewAdapter extends RecyclerView.Adapter<NowPlayingCreditsCrewAdapter.CrewViewHolder> {

    private Context mContext;
    private List<NowPlayingCreditsModel.Crew> crew;
    public ImageLoader imageLoader;
    public DisplayImageOptions options;

    @Override
    public NowPlayingCreditsCrewAdapter.CrewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_credits_crew_cardview, parent, false);

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();


        return new CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NowPlayingCreditsCrewAdapter.CrewViewHolder holder, int position) {

        imageLoader.displayImage(Constants.IMAGE_PATH + crew.get(position).getProfilePath(), holder.posterIV, options);
        holder.nameTV.setText(crew.get(position).getName());
        holder.deptTV.setText(crew.get(position).getDepartment());
        holder.jobTV.setText(crew.get(position).getJob());

    }

    @Override
    public int getItemCount() {
        return crew.size();
    }

    public class CrewViewHolder extends RecyclerView.ViewHolder {

        private ImageView posterIV;
        private TextView nameTV;
        private TextView deptTV;
        private TextView jobTV;

        public CrewViewHolder(View itemView) {
            super(itemView);

            posterIV = (ImageView) itemView.findViewById(R.id.iv_poster_image);
            nameTV = (TextView) itemView.findViewById(R.id.now_playing_crew_name);
            deptTV = (TextView) itemView.findViewById(R.id.now_playing_crew_dept);
            jobTV = (TextView) itemView.findViewById(R.id.now_playing_crew_job);
        }
    }

    public NowPlayingCreditsCrewAdapter(List<NowPlayingCreditsModel.Crew> crew, Context mContext) {
        this.crew = crew;
        this.mContext = mContext;
    }
}
