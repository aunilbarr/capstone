package com.example.expert.core.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expert.core.R
import com.example.expert.core.domain.model.MovieModel
import com.example.expert.core.utils.GlidePhoto
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder>() {

    private val lists = ArrayList<MovieModel>()
    var onItemClickCallback: ((MovieModel) -> Unit)? = null

    fun setData(list: List<MovieModel>) {
        lists.clear()
        lists.addAll(list)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieModel) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(movie.photo.let { GlidePhoto.createGlideImagePath(it) })
                    .centerInside()
                    .into(itemImage)
                itemTitle.text = movie.title
                itemReleaseDate.text = movie.releaseDate
                itemOverview.text = movie.overview
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClickCallback?.invoke(lists[absoluteAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(lists[position])

    override fun getItemCount(): Int = lists.size
}