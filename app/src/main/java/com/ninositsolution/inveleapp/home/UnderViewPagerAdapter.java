package com.ninositsolution.inveleapp.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ninositsolution.inveleapp.R;


/**
 * Created by Parthasarathy D on 1/18/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public class UnderViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private int [] images = {R.drawable.b16, R.drawable.b15, R.drawable.b14,
            R.drawable.b2, R.drawable.b5, R.drawable.b6, R.drawable.b7,
            R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11,
            R.drawable.b12,R.drawable.b13, R.drawable.b3, R.drawable.b2,
            R.drawable.b1 };

    public UnderViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpager_under, null);
        int i = 0;

        if (position<4)
        {
            if (position == 0)
            {
                i = position;

                ImageView under_image_1 = view.findViewById(R.id.under_image_1);
                ImageView under_image_2 = view.findViewById(R.id.under_image_2);

                under_image_1.setImageResource(images[i]);
                under_image_2.setImageResource(images[i+1]);
            }
            else
            {
                i = position*2;


                ImageView under_image_1 = view.findViewById(R.id.under_image_1);
                ImageView under_image_2 = view.findViewById(R.id.under_image_2);

                under_image_1.setImageResource(images[i]);
                under_image_2.setImageResource(images[i+1]);
            }
        }


        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);

    }
}
