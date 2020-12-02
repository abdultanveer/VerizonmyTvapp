package com.next.myapplication

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment

class MainFragment1 : BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI();
    }

    private fun setupUI() {
        title = "verizon title"
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        // set headers background color
        // set headers background color
        brandColor = ContextCompat.getColor(activity!!, R.color.purple_200)
        // set search icon color
        // set search icon color
        searchAffordanceColor = ContextCompat.getColor(activity!!, R.color.teal_200)
    }
}