/*
package com.next.myapplication

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.View
import androidx.core.content.ContextCompat
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import java.util.*
import com.next.myapplication.MovieList;

class MainFragment1 : BrowseSupportFragment() {

    private val TAG = "MainFragment"

    private val BACKGROUND_UPDATE_DELAY = 300
    private val GRID_ITEM_WIDTH = 200
    private val GRID_ITEM_HEIGHT = 200
    private val NUM_ROWS = 6
    private val NUM_COLS = 15

    private val mHandler = Handler()
    private val mDefaultBackground: Drawable? = null
    private val mMetrics: DisplayMetrics? = null
    private val mBackgroundTimer: Timer? = null
    private val mBackgroundUri: String? = null
    private val mBackgroundManager: BackgroundManager? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI();
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

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


    private fun loadRows() {
        var list: List<Movie?> = MovieList.setupMovies()
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter :CardPresenter
        var i: Int
        i = 0
        while (i < NUM_ROWS) {
            if (i != 0) {
                Collections.shuffle(list)
            }
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            for (j in 0 until NUM_COLS) {
                listRowAdapter.add(list[j % 5])
            }
            val header = HeaderItem(i.toLong(), MOVIE_CATEGORY.get(i))
            rowsAdapter.add(ListRow(header, listRowAdapter))
            i++
        }
        val gridHeader = HeaderItem(i.toLong(), "PREFERENCES")
        val mGridPresenter: com.next.mytvapp.MainFragment.GridItemPresenter = com.next.mytvapp.MainFragment.GridItemPresenter()
        val gridRowAdapter = ArrayObjectAdapter(mGridPresenter)
        gridRowAdapter.add(resources.getString(R.string.grid_view))
        gridRowAdapter.add(getString(R.string.error_fragment))
        gridRowAdapter.add(resources.getString(R.string.personal_settings))
        rowsAdapter.add(ListRow(gridHeader, gridRowAdapter))
        adapter = rowsAdapter
    }

    class MovieList {
        var count = 0
        companion object val MOVIE_CATEGORY = arrayOf(
                "Category Zero",
                "Category One",
                "Category Two",
                "Category Three",
                "Category Four",
                "Category Five",
                "Category Six")

        fun setupMovies(): ArrayList<Movie> {
            val list =  ArrayList<Movie>();
            val title = arrayOf(
                    "Zeitgeist 2010_ Year in Review",
                    "Google Demo Slam_ 20ft Search",
                    "Introducing Gmail Blue",
                    "Introducing Google Fiber to the Pole",
                    "Introducing Google Nose"
            )
            val description = ("Fusce id nisi turpis. Praesent viverra bibendum semper. "
                    + "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est "
                    + "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit "
                    + "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit "
                    + "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id "
                    + "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.")
            val studio = arrayOf(
                    "Studio Zero", "Studio One", "Studio Two", "Studio Three", "Studio Four"
            )
            val videoUrl = arrayOf(
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
            )
            val bgImageUrl = arrayOf(
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/bg.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search/bg.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue/bg.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole/bg.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose/bg.jpg")
            val cardImageUrl = arrayOf(
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search/card.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue/card.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole/card.jpg",
                    "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose/card.jpg"
            )
            for (index in title.indices) {
                list
                list.add(
                        buildMovieInfo(
                                title[index],
                                description,
                                studio[index],
                                videoUrl[index],
                                cardImageUrl[index],
                                bgImageUrl[index]))
            }
            return list;
        }

        private fun buildMovieInfo(
                title: String,
                description: String,
                studio: String,
                videoUrl: String,
                cardImageUrl: String,
                backgroundImageUrl: String): Movie {
            var movie = Movie()
            movie.id = count++.toLong();
            movie.title = title;
            movie.description = description;
            movie.studio = studio;
            movie.cardImageUrl = cardImageUrl;
            movie.backgroundImageUrl = backgroundImageUrl
            movie.videoUrl = videoUrl
            */
/* movie.setId(MovieList.count++)
             movie.setTitle(title)
             movie.setDescription(description)
             movie.setStudio(studio)
             movie.setCardImageUrl(cardImageUrl)
             movie.setBackgroundImageUrl(backgroundImageUrl)
             movie.setVideoUrl(videoUrl)*//*

            return movie
        }

    }
}

*/
