package com.esteban.rodriguezo.movies20221.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.esteban.rodriguezo.movies20221.R
import com.esteban.rodriguezo.movies20221.databinding.FragmentDetailBinding
import com.esteban.rodriguezo.movies20221.server.model.Movie
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie: Movie = args.movie
        with(detailBinding){
            movieTitleTextView.text = movie.title
            releaseDateText.text = movie.releaseDate
            voteAverageText.text = movie.voteAverage.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.posterPath).into(posterImageView)
            summaryTextView.text = movie.overview
            Log.d("id",movie.id.toString())
        }
    }
}