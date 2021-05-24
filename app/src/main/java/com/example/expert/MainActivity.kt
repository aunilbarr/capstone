package com.example.expert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fayyadhaunilbarr.core.ui.RecyclerViewAdapter
import com.example.fayyadhaunilbarr.core.domain.model.MovieModel
import com.example.expert.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel<MainViewModel>()

    val viewAdapter: RecyclerViewAdapter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(recyclerview) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewAdapter
        }
        viewAdapter.onItemClickCallback = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
        viewModel.movie.observe(this, androidx.lifecycle.Observer { movies ->
            if (movies != null) loadData(movies)
            else Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG)
                .show()
        })
    }
    private fun loadData(data: List<MovieModel>) {
        mainBar.visibility = View.GONE
        recyclerview.visibility = View.VISIBLE
        viewAdapter.setData(data)
    }
}