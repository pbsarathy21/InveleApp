package com.ninositsolution.inveleapp.my_order;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ninositsolution.inveleapp.R;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder> {

    private Context context;
    private static int currentPosition = -1;

    public MyOrderAdapter(Context context) {
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyOrderViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.adapter_my_order, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderViewHolder myOrderViewHolder, final int i) {

        if (myOrderViewHolder.shipmentLayout.getVisibility() == View.VISIBLE)
        {
            Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
            myOrderViewHolder.shipmentLayout.setVisibility(View.GONE);
            myOrderViewHolder.shipmentLayout.startAnimation(slideUp);

        }

        if (currentPosition == i)
        {
            if (myOrderViewHolder.shipmentLayout.getVisibility() == View.VISIBLE)
            {
                myOrderViewHolder.shipmentLayout.setVisibility(View.GONE);

            }

            else {
                Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
                myOrderViewHolder.shipmentLayout.setVisibility(View.VISIBLE);
                myOrderViewHolder.shipmentLayout.startAnimation(slideDown);
                myOrderViewHolder.shipmentLayout.requestFocus();

            }

        }

        myOrderViewHolder.track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = i;
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyOrderViewHolder extends RecyclerView.ViewHolder{

        TextView track;
        RelativeLayout shipmentLayout;

        public MyOrderViewHolder(@NonNull View itemView) {
            super(itemView);

            track = itemView.findViewById(R.id.track);
            shipmentLayout = itemView.findViewById(R.id.delivered_details_layout);

        }
    }
}
