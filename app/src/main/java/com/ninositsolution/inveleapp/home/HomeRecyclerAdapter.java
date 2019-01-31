package com.ninositsolution.inveleapp.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.AdapterHomeRecyclerBinding;

/**
 * Created by Parthasarathy D on 1/18/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.HomeRecyclerViewHolder> {

    private Context context;
    private int [] images = {R.drawable.mb1, R.drawable.mb2, R.drawable.mb3, R.drawable.mb1, R.drawable.mb2, R.drawable.mb3, R.drawable.mb1, R.drawable.mb2, R.drawable.mb3};

    public HomeRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_home_recycler, viewGroup, false);
        return new HomeRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewHolder homeRecyclerViewHolder, int i) {

        homeRecyclerViewHolder.imageView.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class HomeRecyclerViewHolder extends RecyclerView.ViewHolder{

        AdapterHomeRecyclerBinding binding;
        public ImageView imageView;


        public HomeRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

           imageView = itemView.findViewById(R.id.home_image);
        }
    }
}
