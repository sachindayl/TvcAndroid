package com.sachinda.tvcandroid.models;

import com.google.gson.annotations.SerializedName;

public class OwnerModel {

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    public OwnerModel(String avatarUrl) {
        this.mAvatarUrl = avatarUrl;
    }

    public String getmAvatarUrl() {
        return mAvatarUrl;
    }
}
