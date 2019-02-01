package com.ninositsolution.inveleapp.search_everywhere;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

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
        binding.priceFilterLayout.setVisibility(View.GONE);
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

    @Override
    public void onPriceClicked() {

        if (binding.priceFilterLayout.getVisibility() == View.VISIBLE)
            binding.priceFilterLayout.setVisibility(View.GONE);

            else
                binding.priceFilterLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLowClicked() {
        binding.low.setTextColor(getResources().getColor(R.color.colorPrimary));

            binding.high.setTextColor(getResources().getColor(R.color.textColor));

    }

    @Override
    public void onHighClicked() {

        binding.high.setTextColor(getResources().getColor(R.color.colorPrimary));

            binding.low.setTextColor(getResources().getColor(R.color.textColor));

    }
}
