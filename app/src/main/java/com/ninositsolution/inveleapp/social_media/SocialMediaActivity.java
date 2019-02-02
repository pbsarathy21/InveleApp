package com.ninositsolution.inveleapp.social_media;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivitySocialMediaBinding;

public class SocialMediaActivity extends AppCompatActivity implements ISocialMedia{

    ActivitySocialMediaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_social_media);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_social_media);
        binding.setSocial(new SocialMediaVM(getApplicationContext(), this));
    }

    @Override
    public void onBackClicked() {
        super.onBackPressed();
    }
}
