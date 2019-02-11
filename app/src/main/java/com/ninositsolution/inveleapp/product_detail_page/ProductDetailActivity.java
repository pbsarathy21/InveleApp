package com.ninositsolution.inveleapp.product_detail_page;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends AppCompatActivity implements IProductDetail{

    ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_product_detail);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
        binding.setProduct(new ProductDetailVM(getApplicationContext(), this));
    }

    @Override
    public void onBackClicked() {
            super.onBackPressed();
    }
}
