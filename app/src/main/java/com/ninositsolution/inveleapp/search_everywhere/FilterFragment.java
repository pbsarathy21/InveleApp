package com.ninositsolution.inveleapp.search_everywhere;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.utils.OnSwipeTouchListener;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends Fragment {


    public FilterFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_filter, container, false);


        FrameLayout frameLayout = view.findViewById(R.id.filter_frame);

        frameLayout.setOnTouchListener(new OnSwipeTouchListener(view.getContext()) {

            public void onSwipeRight() {
                assert getFragmentManager() != null;
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                        .remove(Objects.requireNonNull(getFragmentManager()
                                .findFragmentById(R.id.filter_container)))
                        .commit();
            }


        });

        return view;
    }

}
