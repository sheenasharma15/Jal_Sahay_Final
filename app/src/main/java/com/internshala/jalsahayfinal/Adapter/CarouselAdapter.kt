package com.internshala.jalsahayfinal.Adapter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.internshala.jalsahayfinal.R
import androidx.viewpager2.widget.ViewPager2

//class CarouselAdapter : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_carousel_adapter)
//    }
//}

class CarouselAdapter(private val context: Context, private val images: List<Int>) :
    RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_carousel_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageResId = images[position]
        holder.imageView.setImageResource(imageResId)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}