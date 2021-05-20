package com.example.expert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expert.Adapter.RecyclerViewAdapter
import com.example.jetpack.view.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {


    private val viewAdapter: RecyclerViewAdapter by inject()


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
    }
}