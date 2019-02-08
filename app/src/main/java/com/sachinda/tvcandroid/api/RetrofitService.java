package com.sachinda.tvcandroid.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private final static String BASE_URL = "https://api.github.com";

    private static Retrofit retrofitSetup(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static GitHubApi gitHubApiService(){
        return retrofitSetup().create(GitHubApi.class);
    }

}
