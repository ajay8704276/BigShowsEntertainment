package com.app.bigshows.adapters.homepage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.activity.home.AiringTodayDetailActivity;
import com.app.bigshows.model.home.tvshows.OnTheAir_Results;
import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/10/2016.
 */

public class OnTheAirResultAdapter extends RecyclerView.Adapter<OnTheAirResultAdapter.OnTheAirViewHolder>{

    public static final String TV_SHOW_ID = "TV_SHOW_ID";
    private List<OnTheAir_Results> mOnTheAir_resultses ;
    private int rowLayout ;
    private Context mContext;
    public  static int tvShowID;

    private Bundle dataBundle ;
    ImageLoader imageLoader;
    DisplayImageOptions options;


    @Override
    public OnTheAirViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataBundle = new Bundle();
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)

                .build();
        return new OnTheAirViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OnTheAirViewHolder holder, final int position) {

        tvShowID = mOnTheAir_resultses.get(position).getId();
        holder.title.setText(mOnTheAir_resultses.get(position).getName());
        holder.airdate.setText(mOnTheAir_resultses.get(position).getFirstAirDate());
        imageLoader.displayImage(Constants.IMAGE_PATH+mOnTheAir_resultses.get(position).getPosterPath(),holder.imageView,options);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigShowsEntertainmentApp.getSingleInstance().trackEvents("On The Air","Item Clicke",mOnTheAir_resultses.get(position).getName());
                Intent intent = new Intent(mContext,AiringTodayDetailActivity.class);
                intent.putExtra(TV_SHOW_ID,tvShowID);
                view.getContext().startActivity(intent);
            }
        });
       /* try {
            Picasso.with(mContext)
                    .load(Constants.IMAGE_PATH+mOnTheAir_resultses.get(position).getPosterPath())
                    .error(android.R.drawable.stat_notify_error)
                    .placeholder( R.drawable.image_progress_anim )
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }

    @Override
    public int getItemCount() {
        return mOnTheAir_resultses.size();
    }

    public class OnTheAirViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        TextView airdate;
        ImageView imageView;
        Context mContext;
        public OnTheAirViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            cardView = (CardView) itemView.findViewById(R.id.material_cardview);
            title = (TextView) itemView.findViewById(R.id.tv_on_the_air_title);
            airdate = (TextView) itemView.findViewById(R.id.tv_on_the_air_date);
            imageView = (ImageView) itemView.findViewById(R.id.home_on_the_air_images);

        }

    }

    public OnTheAirResultAdapter(List<OnTheAir_Results> results,int rowLayout,Context mContext){
        this.mOnTheAir_resultses = results;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }


}
