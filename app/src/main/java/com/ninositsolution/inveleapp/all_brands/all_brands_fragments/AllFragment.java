package com.ninositsolution.inveleapp.all_brands.all_brands_fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.all_brands.AllBrandsAdapter;
import com.ninositsolution.inveleapp.all_brands.AllBrandsModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {
    RecyclerView recyclerView;
    AllBrandsAdapter recyclerViewAdapter;
    Activity activity;
    List<AllBrandsModel> modelList = new ArrayList<>();


    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        activity = getActivity();
        Initialization(view);
        return view;
    }

    public void Initialization(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.all_brands_recyclerView);




    }




}


