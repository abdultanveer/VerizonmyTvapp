package com.next.myapplication;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.app.BrowseSupportFragment;

public class MainFragment  extends BrowseSupportFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI();
    }

    private void setupUI() {
        setTitle("verizon title");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        // set headers background color
        setBrandColor(ContextCompat.getColor(getActivity(), R.color.purple_200));
        // set search icon color
        setSearchAffordanceColor(ContextCompat.getColor(getActivity(), R.color.teal_200));
    }


    /*private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        *//* GridItemPresenter *//*
        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "GridItemPresenter");

        GridItemPresenter mGridPresenter = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);
        gridRowAdapter.add("ITEM 1");
        gridRowAdapter.add("ITEM 2");
        gridRowAdapter.add("ITEM 3");
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));

        *//* set *//*
        setAdapter(mRowsAdapter);
    }*/
}
