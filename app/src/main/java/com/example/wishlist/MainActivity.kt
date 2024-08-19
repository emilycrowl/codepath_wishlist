package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.wishlist.WishlistAdapter
import com.codepath.wishlist.WishlistItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etItem : EditText = findViewById(R.id.etItem)
        val etPrice : EditText = findViewById(R.id.etPrice)
        val etUrl : EditText = findViewById(R.id.etUrl)
        val btnSubmit : Button = findViewById(R.id.btnSubmit)
        val rvWishlist : RecyclerView = findViewById(R.id.rvWishlist)

        val items: MutableList<WishlistItem> = mutableListOf()
        val wishlistAdapter = WishlistAdapter(items)

        rvWishlist.adapter = wishlistAdapter
        rvWishlist.layoutManager = LinearLayoutManager(this)

        btnSubmit.setOnClickListener {
            val newItem = WishlistItem(
                etItem.text.toString(),
                etUrl.text.toString(),
                etPrice.text.toString().toDouble()
            )

            items.add(newItem)
            wishlistAdapter.notifyItemInserted(items.size - 1)

            etItem.text.clear()
            etPrice.text.clear()
            etUrl.text.clear()
        }
    }
}
