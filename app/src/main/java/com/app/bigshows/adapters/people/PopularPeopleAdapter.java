package com.app.bigshows.adapters.people;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.People.People;
import com.app.bigshows.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay Kumar on 8/3/2016.
 */

public class PopularPeopleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM = 0;
    public static final int LOADING = 1;

    public ImageLoader imageLoader;
    public DisplayImageOptions options;

    public boolean mIsLoadingFooterAdded = false;

    List<People.Result> mPeopleResults;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {

            case ITEM:
                viewHolder = createPopularPeopleViewHolder(parent);
                break;
            case LOADING:
                viewHolder = createPopularPeopleLoadingViewHolder(parent);
                break;

        }

        return viewHolder;
    }

    private RecyclerView.ViewHolder createPopularPeopleLoadingViewHolder(ViewGroup parent) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_more, parent, false);
        final PeopleLoadingViewHolder holder = new PeopleLoadingViewHolder(view);

        return holder;
    }

    private RecyclerView.ViewHolder createPopularPeopleViewHolder(ViewGroup parent) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_people_cardview, parent, false);
        final PopularPeopleViewHolder holder = new PopularPeopleViewHolder(view);
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .postProcessor(new BitmapProcessor() {
                    @Override
                    public Bitmap process(Bitmap bmp) {
                        return Bitmap.createScaledBitmap(bmp, 300, 300, false);
                    }
                })
                .build();

        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case ITEM:
                bindPopularPeopleViewHolder(holder, position);
                break;
            case LOADING:
                bindLoadingViewHolder(holder, position);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return (position == mPeopleResults.size() - 1 && mIsLoadingFooterAdded) ? LOADING : ITEM;
    }

    private void bindLoadingViewHolder(RecyclerView.ViewHolder holder, int position) {

        PeopleLoadingViewHolder mPeopleLoadingViewHolder = (PeopleLoadingViewHolder) holder;
        mPeopleLoadingViewHolder.mLoadMoreProgressbar.setVisibility(View.VISIBLE);
    }

    private void bindPopularPeopleViewHolder(RecyclerView.ViewHolder holder, int position) {

        List<People.KnownFor> mKnownFor = mPeopleResults.get(position).getKnownFor();
        StringBuilder mStringBuilder = new StringBuilder();
        for (int i = 0; i < mKnownFor.size(); i++) {
            if (i != mKnownFor.size()) {
                mStringBuilder.append(mKnownFor.get(i).getTitle());
                mStringBuilder.append(" ");
                mStringBuilder.append(",");
            }
        }
        PopularPeopleViewHolder mPopularPeopleViewHolder = (PopularPeopleViewHolder) holder;
        mPopularPeopleViewHolder.mPeopleNameTV.setText(mPeopleResults.get(position).getName());
        mPopularPeopleViewHolder.mPeopleKnownFor.setText(mStringBuilder);
        imageLoader.displayImage(Constants.IMAGE_PATH + mPeopleResults.get(position).getProfilePath(), mPopularPeopleViewHolder.mPeopleIV, options);
    }

    @Override
    public int getItemCount() {
        return mPeopleResults.size();
    }


    public static class PopularPeopleViewHolder extends RecyclerView.ViewHolder {

        TextView mPeopleNameTV;
        TextView mPeopleKnownFor;
        ImageView mPeopleIV;

        public PopularPeopleViewHolder(View itemView) {
            super(itemView);
            mPeopleNameTV = (TextView) itemView.findViewById(R.id.people_name);
            mPeopleKnownFor = (TextView) itemView.findViewById(R.id.people_knownfor);
            mPeopleIV = (ImageView) itemView.findViewById(R.id.popular_imageview);
        }
    }

    public static class PeopleLoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar mLoadMoreProgressbar;

        public PeopleLoadingViewHolder(View itemView) {
            super(itemView);
            mLoadMoreProgressbar = (ProgressBar) itemView.findViewById(R.id.loading_iv);
        }
    }


    //Helper method for updating adapter
    // region Helper Methods
    private void add(People.Result item) {
        mPeopleResults.add(item);
        notifyItemInserted(mPeopleResults.size() - 1);
    }

    public void addAll(List<People.Result> results) {
        for (People.Result result : results) {
            add(result);
        }
    }

    public void remove(People.Result item) {
        int position = mPeopleResults.indexOf(item);
        if (position > -1) {
            mPeopleResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        mIsLoadingFooterAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoading() {
        mIsLoadingFooterAdded = true;
        add(new People.Result());
    }

    public void removeLoading() {
        mIsLoadingFooterAdded = false;

        int position = mPeopleResults.size() - 1;
        People.Result item = getItem(position);

        if (item != null) {
            mPeopleResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public People.Result getItem(int position) {
        return mPeopleResults.get(position);
    }


    public PopularPeopleAdapter() {

        mPeopleResults = new ArrayList<>();
    }

}
