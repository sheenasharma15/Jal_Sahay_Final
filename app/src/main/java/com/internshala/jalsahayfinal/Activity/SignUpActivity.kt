package com.internshala.jalsahayfinal.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.internshala.jalsahayfinal.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signupButton: Button = findViewById(R.id.btnSignUp)
        signupButton.setOnClickListener{
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}