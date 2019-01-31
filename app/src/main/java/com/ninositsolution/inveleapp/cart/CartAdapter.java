package com.ninositsolution.inveleapp.cart;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ninositsolution.inveleapp.R;

/**
 * Created by Parthasarathy D on 1/22/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;

    public CartAdapter(Context context) {
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_cart, viewGroup, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{

        TextView delete;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            delete = itemView.findViewById(R.id.cart_delete_rate);

            delete.setPaintFlags(delete.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
