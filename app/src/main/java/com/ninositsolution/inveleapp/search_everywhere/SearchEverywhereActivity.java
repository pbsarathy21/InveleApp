package com.ninositsolution.inveleapp.search_everywhere;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivitySearchEverywhereBinding;
import com.ninositsolution.inveleapp.recently_viewed.RecentlyViewedAdapter;

public class SearchEverywhereActivity extends AppCompatActivity implements ISearchEverywhere{

    ActivitySearchEverywhereBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search_everywhere);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_everywhere);
        binding.setSearchEverywhere(new SearchEverywhereVM(getApplicationContext(), this));
    }

    @Override
    public void onBackClicked() {
        super.onBackPressed();
    }

    @Override
    public void setRecyclerAdapter(RecentlyViewedAdapter recyclerAdapter) {

        binding.recentlyViewedRecyclerview.setHasFixedSize(true);
        binding.recentlyViewedRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recentlyViewedRecyclerview.setAdapter(recyclerAdapter);

    }
}
