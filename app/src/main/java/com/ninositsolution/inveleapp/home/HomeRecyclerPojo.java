package com.ninositsolution.inveleapp.home;

import android.widget.ImageView;

/**
 * Created by Parthasarathy D on 1/18/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public class HomeRecyclerPojo {

    private ImageView imageView;

    public HomeRecyclerPojo(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
