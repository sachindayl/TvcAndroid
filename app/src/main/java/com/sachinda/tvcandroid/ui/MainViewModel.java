package com.sachinda.tvcandroid.ui;

import com.sachinda.tvcandroid.api.RetrofitService;
import com.sachinda.tvcandroid.models.GitHubRepositoriesModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<GitHubRepositoriesModel> _repositoriesListWatcher = new MutableLiveData<>();
    final LiveData<GitHubRepositoriesModel> repositoriesListWatcher = _repositoriesListWatcher;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel() {

    }

    void onDestroy() {
        compositeDisposable.dispose();
    }

    void getRepositoriesList(String searchQuery) {
        Disposable disposable = RetrofitService.gitHubApiService()
                .getRepositories(searchQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        _repositoriesListWatcher::setValue,
                        Throwable::printStackTrace
                );

        compositeDisposable.add(disposable);
    }


}
