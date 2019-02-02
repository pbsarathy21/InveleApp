package com.ninositsolution.inveleapp.social_media;

import android.content.Context;

public class SocialMediaVM {

    private SocialMediaModel socialMediaModel;
    private Context context;
    private ISocialMedia iSocialMedia;

    public SocialMediaVM(Context context, ISocialMedia iSocialMedia) {
        this.context = context;
        this.iSocialMedia = iSocialMedia;
        socialMediaModel = new SocialMediaModel();
    }

    //ClickListeners

    public void onBackClicked()
    {
        iSocialMedia.onBackClicked();
    }
}
