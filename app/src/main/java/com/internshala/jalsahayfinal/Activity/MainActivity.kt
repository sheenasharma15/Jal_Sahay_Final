package com.internshala.jalsahayfinal.Activity


import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.internshala.jalsahayfinal.Adapter.CarouselAdapter
import com.internshala.jalsahayfinal.R
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {



    private lateinit var viewPager: ViewPager
    private lateinit var timer: Timer

    lateinit var mapButton: Button
    lateinit var profileButton: Button
    lateinit var homeButton: Button
    lateinit var helpButton: Button
    lateinit var cameraButton: Button


    private val images =
        listOf(R.drawable.floods, R.drawable.pipeline,
            R.drawable.drainage, R.drawable.potholes,
            R.drawable.carousel1,R.drawable.carousel2,
            R.drawable.carousel3)

    private var currentPage = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        main to profile
        profileButton = findViewById(R.id.btnProfile)
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }



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

        //     MAP CODE
        mapButton = findViewById(R.id.btnMap)

        mapButton.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        helpButton = findViewById(R.id.btnContact)

        helpButton.setOnClickListener{
            val intent = Intent(this,HelpActivity::class.java)
            startActivity(intent)
        }

        homeButton = findViewById(R.id.btnHome)

        homeButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        // Stop the timer when the activity is destroyed
        timer.cancel()
    }
}

