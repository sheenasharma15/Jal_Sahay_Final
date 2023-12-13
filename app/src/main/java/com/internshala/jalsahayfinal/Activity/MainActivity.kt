package com.internshala.jalsahayfinal.Activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.internshala.jalsahayfinal.Adapter.CarouselAdapter
import com.internshala.jalsahayfinal.R
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {



    private lateinit var viewPager: ViewPager
    private lateinit var timer: Timer

    lateinit var mapButton: Button
    private val images =
        listOf(R.drawable.floods, R.drawable.pipeline,
            R.drawable.drainage, R.drawable.potholes,
            R.drawable.carousel1,R.drawable.carousel2,
            R.drawable.carousel3)

    private var currentPage = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //  carousel code
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = CarouselAdapter(this, images)
        viewPager.adapter = adapter

        // Show the first three images initially
        viewPager.currentItem = 0

        // Set up a timer to change the page every 2 seconds
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (currentPage == images.size) {
                        currentPage = 0
                    }
                    viewPager.setCurrentItem(currentPage++, true)
                }
            }
        }, 2000, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop the timer when the activity is destroyed
        timer.cancel()


//     MAP CODE
        mapButton = findViewById(R.id.btnMap)
        mapButton.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }


    }
}


