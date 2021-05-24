package com.example.expert

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import org.koin.android.viewmodel.compat.ViewModelCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.fayyadhaunilbarr.core.domain.model.DetailModel
import com.example.expert.ViewModel.DetailViewModel
import com.example.fayyadhaunilbarr.core.domain.model.MovieModel
import com.example.fayyadhaunilbarr.core.utils.GlidePhoto
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_STATE = "extra_state"

    }

    private val viewModel: DetailViewModel by viewModel<DetailViewModel>()
    private var isFavorite = false
    private lateinit var movie: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolBar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)
        collapsingToolBar.title = getString(R.string.detail)
        collapsingToolBar.setExpandedTitleColor(Color.TRANSPARENT)
        collapsingToolBar.setCollapsedTitleTextColor(Color.TRANSPARENT)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        movie = intent.getParcelableExtra<MovieModel>(EXTRA_DATA) as MovieModel
        loadImage(movie.photo.toString())
        viewModel.getDetail(movie.id).observe(this, Observer { details ->
            if (details != null) {
                loadDetail(details, movie)
                showUI()
            } else {
                loadDetail(null, movie)
            }
        })


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun loadImage(imagePath: String) {
        Glide.with(this)
            .load(GlidePhoto.createGlideImagePath(imagePath))
            .into(movieImage)
    }

    private fun loadDetail(details: DetailModel?, movie: MovieModel) {
        if (details != null) {
            detailTitle.text = movie.title
            releasedate.text = movie.releaseDate
            score.text = movie.voteAverage.toString()
            genre.text = details.genre.toString()
            detailDescription.text = movie.overview
        } else {
            detailBar.visibility = View.GONE
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show()
        }
    }

    private fun showUI() {
        detailBar.visibility = View.GONE
        detailView.visibility = View.VISIBLE
        movieImage.visibility = View.VISIBLE
    }
}