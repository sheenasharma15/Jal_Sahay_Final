package com.internshala.jalsahayfinal.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.internshala.jalsahayfinal.Adapter.CarouselAdapter
import com.internshala.jalsahayfinal.R

class HomePageActivity : AppCompatActivity() {

    private val images = listOf(R.drawable.floods, R.drawable.pipeline, R.drawable.drainage, R.drawable.potholes)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = CarouselAdapter(this, images)

        viewPager.adapter = adapter

    }
}