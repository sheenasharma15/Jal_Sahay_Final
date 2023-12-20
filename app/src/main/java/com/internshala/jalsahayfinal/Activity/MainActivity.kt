package com.internshala.jalsahayfinal.Activity


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.RetryPolicy
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.internshala.jalsahayfinal.Adapter.CarouselAdapter
import com.internshala.jalsahayfinal.R
import org.json.JSONObject
import java.util.Timer
import java.util.TimerTask



class MainActivity : AppCompatActivity() {

    private lateinit var requestQueue: RequestQueue



    private lateinit var viewPager: ViewPager
    private lateinit var timer: Timer

    lateinit var mapButton: Button
    lateinit var profileButton: Button
    lateinit var homeButton: Button
    lateinit var helpButton: Button
    lateinit var cameraButton: Button
    lateinit var reportButton:Button


    private val images =
        listOf(R.drawable.floods, R.drawable.pipeline,
            R.drawable.drainage, R.drawable.potholes,
            R.drawable.carousel1,R.drawable.carousel2,
            R.drawable.carousel3)

    private var currentPage = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//VOLLEY CODE

        requestQueue = Volley.newRequestQueue(this)
        val apiUrl = "https://titans.thelinuxserver.cloud/classifyandpred/"
        val postData = JSONObject()
        postData.put("firebase_url", "https://firebasestorage.googleapis.com/v0/b/base-project-14a6e.appspot.com/o/uploads%2Fimages%2F1702829207442-Screenshot%20(738).png?alt=media&token=c7912b57-c289-4ace-8bfa-dfba2f8e3ea2")
        val request = JsonObjectRequest(
            Request.Method.POST, apiUrl, postData,
            { response ->
                println("response is "+response)


                val className: String = response.getString("class")

                val confidence: String = response.getString("confidence")

            },
            { error ->
                println("response is "+error)
            }
        )
        requestQueue.add(request)

        request.retryPolicy = object : RetryPolicy {
            override fun getCurrentTimeout(): Int {
                return 50000
            }

            override fun getCurrentRetryCount(): Int {
                return 50000
            }

            @Throws(VolleyError::class)
            override fun retry(error: VolleyError) {
            }
        }







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

        reportButton = findViewById(R.id.report_Button_main)
        reportButton.setOnClickListener{
            val intent = Intent(this,ReportActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop the timer when the activity is destroyed
        timer.cancel()
    }
}


