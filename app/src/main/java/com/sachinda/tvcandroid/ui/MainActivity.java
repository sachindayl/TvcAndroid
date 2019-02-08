package com.sachinda.tvcandroid.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sachinda.tvcandroid.R;
import com.sachinda.tvcandroid.adapters.GithubRepositoryAdapter;
import com.sachinda.tvcandroid.models.GitHubRepositoriesModel;
import com.sachinda.tvcandroid.models.ItemsModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;
    ImageButton searchButton;
    EditText searchBar;
    RecyclerView itemsRv;
    LinearLayoutManager mLayoutManager;
    GithubRepositoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);
        searchButton = findViewById(R.id.btn_search);
        searchBar = findViewById(R.id.et_search_bar);
        itemsRv = findViewById(R.id.rv_items);
        mLayoutManager = new LinearLayoutManager(this);
        itemsRv.setLayoutManager(mLayoutManager);
        List<ItemsModel> itemsModels = new ArrayList<>();
        GitHubRepositoriesModel gitList = new GitHubRepositoriesModel(itemsModels);
        mAdapter = new GithubRepositoryAdapter(gitList);
        itemsRv.setAdapter(mAdapter);
        observeItems();

        searchButton.setOnClickListener(v -> viewModel.getRepositoriesList(searchBar.getText().toString()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing())
            viewModel.onDestroy();
    }

    /**
     * Observes live data objects to display values
     */
    private void observeItems(){
        viewModel.repositoriesListWatcher.observe(this, gitHubRepositoriesModels -> {
            mAdapter.setData(gitHubRepositoriesModels);
        });
    }

}
