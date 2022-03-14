package com.esteban.rodriguezo.movies20221.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.esteban.rodriguezo.movies20221.databinding.FragmentListBinding

class ListFragment : Fragment() {


    private lateinit var listviewModel: ListViewModel
    private lateinit var listBinding: FragmentListBinding
    private lateinit var  moviesAdapter :MoviesAdapter
    private var moviesList: ArrayList<Movies> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        listBinding = FragmentListBinding.inflate(inflater,container,false)
        listviewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesAdapter = MoviesAdapter(moviesList, onItemClicked = { onMovieItemClicked(it)})

        listBinding.moviesRecyclerView.apply{
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = moviesAdapter
            setHasFixedSize(false)
        }

        listviewModel.getMovies()
    }
    private fun onMovieItemClicked(it: Movie){

    }


}