package com.example.mobiledevproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(var products: List<Product>, var context: Context): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val image: ImageView = view.findViewById(R.id.product_list_image)
        val title: TextView = view.findViewById(R.id.product_list_title)
        val desc: TextView = view.findViewById(R.id.product_list_desc)
        val price: TextView = view.findViewById(R.id.product_list_price)
        val button: Button = view.findViewById(R.id.product_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_in_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = products[position].title
        holder.desc.text = products[position].shortDesc
        holder.price.text = products[position].price.toString()

        val imageId = context.resources.getIdentifier(products[position].image, "drawable", context.packageName)

        holder.image.setImageResource(imageId)

        holder.button.setOnClickListener {
            val intent = Intent(context, ProductsActivity::class.java)
            intent.putExtra("productTitle", products[position].title)
            intent.putExtra("productText", products[position].longDesc)
            // + price, image id
            context.startActivity(intent)
        }

    }

}