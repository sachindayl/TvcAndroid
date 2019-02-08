package com.sachinda.tvcandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.sachinda.tvcandroid.R;
import com.sachinda.tvcandroid.models.GitHubRepositoriesModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GithubRepositoryAdapter extends RecyclerView.Adapter<GithubRepositoryAdapter.GithubRepositoryViewHolder> {
    private GitHubRepositoriesModel mRepositoryList;


    public GithubRepositoryAdapter(GitHubRepositoriesModel repositoryList) {
        this.mRepositoryList = repositoryList;
    }

    public void setData(GitHubRepositoriesModel newList) {
        mRepositoryList = newList;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public GithubRepositoryAdapter.GithubRepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                                 int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.github_list_item, parent, false);
        return new GithubRepositoryViewHolder(v, mRepositoryList);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class GithubRepositoryViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mTitle;
        TextView mDescription;
        ImageView mAvatar;
        TextView mStars;
        GitHubRepositoriesModel mRepositoriesModelList;
        View mView;

        GithubRepositoryViewHolder(View v, GitHubRepositoriesModel repositoriesModelList) {
            super(v);
            mTitle = v.findViewById(R.id.title);
            mDescription = v.findViewById(R.id.description);
            mAvatar = v.findViewById(R.id.avatar);
            mStars = v.findViewById(R.id.stars);
            mView = v;
            mRepositoriesModelList = repositoriesModelList;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull GithubRepositoryViewHolder holder, int position) {
        holder.mTitle.setText(mRepositoryList.getmItemsModel().get(position).getmName());
        holder.mDescription.setText(mRepositoryList.getmItemsModel().get(position).getmDescription());
        String starsText = "★ " + mRepositoryList.getmItemsModel().get(position).getmStars();
        holder.mStars.setText(starsText);
        String imageUrl = mRepositoryList.getmItemsModel().get(position).getmOwnerModel().getmAvatarUrl();
        if (!imageUrl.equals("")) {
            Glide.with(holder.mView.getContext())
                    .load(imageUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .into(holder.mAvatar);
        }


    }

    @Override
    public int getItemCount() {
        return mRepositoryList.getmItemsModel().size();
    }
}
