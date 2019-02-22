package com.ninositsolution.inveleapp.cart;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityCartBinding;
import com.ninositsolution.inveleapp.home.HomeActivity;
import com.ninositsolution.inveleapp.payment.PaymentActivity;
import com.ninositsolution.inveleapp.size_chart.SizeChartActivity;

public class CartActivity extends AppCompatActivity implements ICart {

    ActivityCartBinding binding;
    BottomSheetBehavior bottomSheetBehavior;
    BottomSheetBehavior behavior;
    TextView size_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        binding.setCart(new CartVM(getApplicationContext(), this));

        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetCart);

        size_chart = (TextView)findViewById(R.id.size_chart);

        size_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, SizeChartActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void loadCartRecyclerView(CartAdapter cartAdapter) {

        binding.cartRecyclerview.setHasFixedSize(true);
        binding.cartRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRecyclerview.setAdapter(cartAdapter);

    }






    @Override
    public void onBackClicked() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onEditClicked(int position) {

        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED)
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        else
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void onContinueClicked() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onCheckoutClicked() {

        startActivity(new Intent(this, PaymentActivity.class));

    }
}