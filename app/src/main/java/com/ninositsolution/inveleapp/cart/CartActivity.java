package com.ninositsolution.inveleapp.cart;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityCartBinding;
import com.ninositsolution.inveleapp.home.HomeActivity;

public class CartActivity extends AppCompatActivity implements ICart{

    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        binding.setCart(new CartVM(getApplicationContext(), this));
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
}