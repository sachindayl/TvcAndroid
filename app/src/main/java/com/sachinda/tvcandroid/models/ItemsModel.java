package com.sachinda.tvcandroid.models;

import com.google.gson.annotations.SerializedName;

public class ItemsModel {

    @SerializedName("full_name")
    private String mName;
    @SerializedName("owner")
    private OwnerModel mOwnerModel;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("stargazers_count")
    private int mStars;

    public ItemsModel(
            String name,
            OwnerModel ownerModel,
            String description,
            int stars
    ) {
        this.mName = name;
        this.mOwnerModel = ownerModel;
        this.mDescription = description;
        this.mStars = stars;
    }

    public String getmName() {
        return mName;
    }

    public OwnerModel getmOwnerModel() {
        return mOwnerModel;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmStars() {
        return mStars;
    }
}
