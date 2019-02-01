package com.ninositsolution.inveleapp.search_everywhere;

import android.content.Context;

import com.ninositsolution.inveleapp.recently_viewed.RecentlyViewedAdapter;
import com.ninositsolution.inveleapp.search.SearchModel;

/**
 * Created by Parthasarathy D on 1/30/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public class SearchEverywhereVM {

    private SearchModel searchModel;
    private Context context;
    private ISearchEverywhere iSearchEverywhere;


    public SearchEverywhereVM(Context context, ISearchEverywhere iSearchEverywhere) {
        this.context = context;
        this.iSearchEverywhere = iSearchEverywhere;
        searchModel = new SearchModel();
        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {

        RecentlyViewedAdapter recentlyViewedAdapter = new RecentlyViewedAdapter(context);
        iSearchEverywhere.setRecyclerAdapter(recentlyViewedAdapter);

    }

    //ClickListeners

    public void onBackClicked()
    {
        iSearchEverywhere.onBackClicked();
    }

    public void onPriceClicked()
    {
        iSearchEverywhere.onPriceClicked();
    }

    public void onLowClicked()
    {
        iSearchEverywhere.onLowClicked();
    }

    public void onHighClicked()
    {
        iSearchEverywhere.onHighClicked();
    }
}
