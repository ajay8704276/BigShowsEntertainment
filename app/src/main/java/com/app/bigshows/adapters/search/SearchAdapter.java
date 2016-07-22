package com.app.bigshows.adapters.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bigshows.R;
import com.app.bigshows.model.search.SearchWrapper;

import java.util.List;

/**
 * Created by Ajay Kumar on 7/21/2016.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    List<SearchWrapper> mSearchResult ;
    int rowLayout;
    private  Context mContext;
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return  new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchAdapter.SearchViewHolder holder, int position) {

        holder.mSearchTextView.setText(mSearchResult.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mSearchResult.size();
    }

    public  class SearchViewHolder  extends RecyclerView.ViewHolder {

        TextView mSearchTextView ;
        public SearchViewHolder(View itemView) {
            super(itemView);

            mSearchTextView = (TextView) itemView.findViewById(R.id.search_result_text);
        }
    }


    public SearchAdapter(List<SearchWrapper> results, int rowLayout, Context mContext){
        this.mSearchResult = results;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }
}
