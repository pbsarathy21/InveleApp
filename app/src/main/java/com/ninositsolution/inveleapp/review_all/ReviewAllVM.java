package com.ninositsolution.inveleapp.review_all;

import android.content.Context;

public class ReviewAllVM {

    private ReviewAllModel reviewAllModel;
    private Context context;
    private IReviewAll iReviewAll;

    public ReviewAllVM(Context context, IReviewAll iReviewAll) {
        this.context = context;
        this.iReviewAll = iReviewAll;
        reviewAllModel = new ReviewAllModel();
        loadAdapter();
    }

    private void loadAdapter() {

        ReviewAllAdapter reviewAllAdapter = new ReviewAllAdapter(context);
        iReviewAll.setRecyclerAdapter(reviewAllAdapter);
    }

    public void onBackClicked()
    {
        iReviewAll.onBackClicked();
    }
}
