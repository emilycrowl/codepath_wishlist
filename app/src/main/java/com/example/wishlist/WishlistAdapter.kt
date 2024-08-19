package com.codepath.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R

class WishlistAdapter(private val items: MutableList<WishlistItem>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvItem: TextView = itemView.findViewById(R.id.tvItem)
        val tvUrl: TextView = itemView.findViewById(R.id.tvUrl)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.tvItem.text = item.name
        holder.tvUrl.text = item.url
        holder.tvPrice.text = item.price.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

}