package com.example.expert.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expert.DetailActivity
import com.example.expert.core.domain.model.MovieModel
import com.example.expert.core.ui.RecyclerViewAdapter
import com.example.expert.favoriteModule
import kotlinx.android.synthetic.main.activity_favorite.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class favoriteActivity : AppCompatActivity() {


    private val viewModel: favoriteViewModel by viewModel()
    private val favoriteAdapter : RecyclerViewAdapter by inject<RecyclerViewAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        loadKoinModules(favoriteModule)
        setSupportActionBar(toolbar_fav)
        supportActionBar?.title = "Your Favorite"

        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_fav)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        with(recyclerviewfav){
            layoutManager = LinearLayoutManager(this@favoriteActivity)
            adapter = favoriteAdapter
        }
        favoriteAdapter.onItemClickCallback = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        viewModel.favorites.observe(this, Observer { favorites ->
            if (favorites != null) loadData(favorites)
            else Toast.makeText(this, getString(R.string.no_fav), Toast.LENGTH_LONG)
                .show()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun loadData(data: List<MovieModel>) {
        favBar.visibility = View.GONE
        recyclerviewfav.visibility = View.VISIBLE
        favoriteAdapter.setData(data)
    }
}