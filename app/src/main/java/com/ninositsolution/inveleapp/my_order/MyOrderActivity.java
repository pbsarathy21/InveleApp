package com.ninositsolution.inveleapp.my_order;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityMyOrderBinding;
import com.ninositsolution.inveleapp.product_review.ProductReviewActivity;

public class MyOrderActivity extends AppCompatActivity implements IMyOrder{

    ActivityMyOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_my_order);*/
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_order);
        binding.setMyOrder(new MyOrderVM(getApplicationContext(), this));
    }

    @Override
    public void onBackClicked() {
        super.onBackPressed();
    }

    @Override
    public void setRecyclerAdapter(MyOrderAdapter myOrderAdapter) {
            binding.orderRecyclerView.setHasFixedSize(true);
            binding.orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            binding.orderRecyclerView.setAdapter(myOrderAdapter);
    }

    @Override
    public void reviewClicked(int position) {
        startActivity(new Intent(this, ProductReviewActivity.class));


    }
}
