package com.ninositsolution.inveleapp.review_all;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityReviewAllBinding;

public class ReviewAllActivity extends AppCompatActivity implements IReviewAll{

    ActivityReviewAllBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_review_all);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_review_all);
        binding.setReviewAll(new ReviewAllVM(getApplicationContext(), this));
    }

    @Override
    public void onBackClicked() {

        super.onBackPressed();

    }

    @Override
    public void setRecyclerAdapter(ReviewAllAdapter recyclerAdapter) {

        binding.reviewAllRecyclerView.setHasFixedSize(true);
        binding.reviewAllRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.reviewAllRecyclerView.setAdapter(recyclerAdapter);

    }
}
