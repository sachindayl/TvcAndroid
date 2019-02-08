package com.sachinda.tvcandroid.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitHubRepositoriesModel {

    @SerializedName("items")
    private List<ItemsModel> mItemsModel;


    public GitHubRepositoriesModel(
            List<ItemsModel> itemsModel
    ) {
        this.mItemsModel = itemsModel;
    }

    public List<ItemsModel> getmItemsModel() {
        return mItemsModel;
    }
}
