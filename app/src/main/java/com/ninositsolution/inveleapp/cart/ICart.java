package com.ninositsolution.inveleapp.cart;

/**
 * Created by Parthasarathy D on 1/17/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public interface ICart {

    void loadCartRecyclerView(CartAdapter cartAdapter);
    void onBackClicked();
}
