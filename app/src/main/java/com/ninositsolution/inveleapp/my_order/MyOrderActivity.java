package com.ninositsolution.inveleapp.my_order;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityMyOrderBinding;

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
}
