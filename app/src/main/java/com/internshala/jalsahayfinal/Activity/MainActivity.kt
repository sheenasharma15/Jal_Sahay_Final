package com.internshala.jalsahayfinal.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.internshala.jalsahayfinal.Adapter.CarouselAdapter
import com.internshala.jalsahayfinal.Fragments.HelpFragment
import com.internshala.jalsahayfinal.Fragments.LangaugeFragment
import com.internshala.jalsahayfinal.Fragments.LogoutFragment
import com.internshala.jalsahayfinal.Fragments.SettingsFragment
import com.internshala.jalsahayfinal.R
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

// CODE FOR CAROUSEL AND TIMER
    private lateinit var viewPager: ViewPager
    private lateinit var timer: Timer
    private val images = listOf(
        R.drawable.floods, R.drawable.pipeline,
        R.drawable.drainage, R.drawable.potholes,
        R.drawable.carousel1,R.drawable.carousel2,
        R.drawable.carousel3)

    private var currentPage = 0
    private val initialPageSize = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//CAROUSEL CODE
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = CarouselAdapter(this, images)
        viewPager.adapter = adapter

        // Show the first three images initially
        viewPager.currentItem = initialPageSize

        // Set up a timer to change the page every 2 seconds
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (currentPage == images.size) {
                        currentPage = initialPageSize
                    }
                    viewPager.setCurrentItem(currentPage++, true)
                }
            }
        }, 1800, 1800)
    }
    override fun onDestroy() {
        super.onDestroy()
        // Stop the timer when the activity is destroyed
        timer.cancel()

    }
}

