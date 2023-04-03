package com.ewa.ewalivecoding.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewa.ewalivecoding.R
import com.ewa.ewalivecoding.domain.BookTime
import java.util.*

class ListAdapter(val callback: ((book: BookTime) -> Unit)? = null)
    : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var mBooks: MutableList<BookTime> = mutableListOf<BookTime>()

    fun setBooks(books: List<BookTime>): Boolean {
        return mBooks.addAll(books)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_item_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mBooks[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return mBooks.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val imageView: ImageView = itemView.findViewById(R.id.image_view)
        private val authorView = itemView.findViewById<TextView>(R.id.author)
        private val time = itemView.findViewById<TextView>(R.id.time)

        fun bind(item: BookTime) {
            val book = item.book
            titleTextView.text = book.title
            if (book.author != null)
                authorView.text = book.author
            imageView.setImageResource(book.image)
            if (item.openTime >= 0)
                time.text = Date(item.openTime).toString()

            itemView.setOnClickListener {
                callback?.invoke(item)
            }
        }
    }

}