package com.ninositsolution.inveleapp.search_everywhere;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivitySearchEverywhereBinding;
import com.ninositsolution.inveleapp.recently_viewed.RecentlyViewedAdapter;
import com.ninositsolution.inveleapp.utils.OnSwipeTouchListener;

import java.util.Objects;

public class SearchEverywhereActivity extends AppCompatActivity implements ISearchEverywhere{

    ActivitySearchEverywhereBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search_everywhere);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_everywhere);
        binding.setSearchEverywhere(new SearchEverywhereVM(getApplicationContext(), this));
        binding.priceFilterLayout.setVisibility(View.GONE);

        /*binding.recentlyViewedRecyclerview.setOnTouchListener(new OnSwipeTouchListener(this) {

          *//*  public void onSwipeTop() {
                Toast.makeText(getApplicationContext(), "top", Toast.LENGTH_SHORT).show();
            }*//*
            public void onSwipeRight() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(Objects.requireNonNull(getSupportFragmentManager()
                                .findFragmentById(R.id.filter_container)))
                        .commit();
            }
            public void onSwipeLeft() {
                Toast.makeText(getApplicationContext(), "left", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FilterFragment filterFragment = new FilterFragment();
                fragmentTransaction.add(R.id.filter_container, filterFragment);
                fragmentTransaction.commit();
            }
         *//*   public void onSwipeBottom() {
                Toast.makeText(getApplicationContext(), "bottom", Toast.LENGTH_SHORT).show();
            }*//*

        });*/
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

    @Override
    public void onFilterClicked() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FilterFragment filterFragment = new FilterFragment();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        fragmentTransaction.add(R.id.filter_container, filterFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onRelevanceClicked() {

        Toast.makeText(this, "Relevance Under Production", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onEveryWhereClicked() {

        Toast.makeText(this, "Everywhere Under Production", Toast.LENGTH_SHORT).show();

    }


}
