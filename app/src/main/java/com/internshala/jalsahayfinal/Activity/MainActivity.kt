package com.internshala.jalsahayfinal.Activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.internshala.jalsahayfinal.Adapter.CarouselAdapter
import com.internshala.jalsahayfinal.R


class MainActivity : AppCompatActivity() {

    lateinit var mapButton: Button
    private val images = listOf(R.drawable.floods, R.drawable.pipeline, R.drawable.drainage, R.drawable.potholes)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = CarouselAdapter(this, images)

        viewPager.adapter = adapter

        mapButton = findViewById(R.id.btnMap)

        mapButton.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}

