package com.sachinda.tvcandroid.api;

import com.sachinda.tvcandroid.models.GitHubRepositoriesModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubApi {

    @GET("/search/repositories")
    Observable<GitHubRepositoriesModel> getRepositories(@Query("q") String searchValue);


}
