package com.ninositsolution.inveleapp.categories;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.cart.CartActivity;
import com.ninositsolution.inveleapp.categories.fragments.fragment_all_categories.AllCategoriesFragment;
import com.ninositsolution.inveleapp.categories.fragments.fragment_other_categories.OtherCategoriesFragment;
import com.ninositsolution.inveleapp.databinding.ActivityCategoryBinding;
import com.ninositsolution.inveleapp.home.HomeActivity;
import com.ninositsolution.inveleapp.utils.Session;

public class CategoryActivity extends AppCompatActivity implements ICategory{

    private ActivityCategoryBinding binding;
    FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private AllCategoriesFragment allCategoriesFragment = new AllCategoriesFragment();
    private OtherCategoriesFragment otherCategoriesFragment = new OtherCategoriesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category);
        binding.setCategory(new CategoryVM(getApplicationContext(), this));

        //All Categories selected as default
        binding.allCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.allCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        allCategoriesFragment = new AllCategoriesFragment();
        fragmentTransaction.add(R.id.container_category, allCategoriesFragment).commit();

    }

    private void changeFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        otherCategoriesFragment = new OtherCategoriesFragment();
        fragmentTransaction.replace(R.id.container_category, otherCategoriesFragment).commit();
    }

    @Override
    public void AllCategoriesClicked() {

        binding.allCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.allCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        allCategoriesFragment = new AllCategoriesFragment();
        fragmentTransaction.replace(R.id.container_category, allCategoriesFragment).commit();

    }

    @Override
    public void MensCategoriesClicked() {

        binding.mensCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.mensCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }


    @Override
    public void WomensCategoriesClicked() {

        binding.womensCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.womensCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void BoysCategoriesClicked() {

        binding.boysCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.boysCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void MobilesCategoriesClicked() {

        binding.mobilesCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.mobilesCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void ElectronicsCategoriesClicked() {

        binding.electronicsCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.electronicsCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();
    }

    @Override
    public void HomeCategoriesClicked() {

        binding.homeCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.homeCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void BabiesCategoriesClicked() {

        binding.babiesCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.babiesCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void BeautyCategoriesClicked() {

        binding.beautyCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.beautyCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void HealthCategoriesClicked() {

        binding.healthCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.healthCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void BooksCategoriesClicked() {

        binding.booksCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.white));
        binding.booksCategoriesText.setTextColor(getResources().getColor(R.color.colorPrimary));
        changeFragment();

    }

    @Override
    public void onBackClicked() {

        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onSearchClicked() {

        startActivity(new Intent(this, CartActivity.class));

    }

    @Override
    public void onCartClicked() {

    }


    @Override
    public void ChangePreviousCategoryView() {

        Session session = new Session(this);

        int position = session.getCategoryPosition();

        switch (position)
        {
            case 1:
                binding.allCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.allCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 2:
                binding.mensCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.mensCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 3:
                binding.womensCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.womensCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 4:
                binding.boysCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.boysCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 5:
                binding.mobilesCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.mobilesCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 6:
                binding.electronicsCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.electronicsCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 7:
                binding.homeCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.homeCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 8:
                binding.babiesCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.babiesCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 9:
                binding.beautyCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.beautyCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 10:
                binding.healthCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.healthCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;

            case 11:
                binding.booksCategoriesLayout.setBackgroundColor(getResources().getColor(R.color.grayWhite));
                binding.booksCategoriesText.setTextColor(getResources().getColor(R.color.textColor));
                break;
        }


    }


    @Override
    protected void onStart() {

        Session session = new Session(this);
        session.setCategoryPosition(1);

        super.onStart();
    }
}
