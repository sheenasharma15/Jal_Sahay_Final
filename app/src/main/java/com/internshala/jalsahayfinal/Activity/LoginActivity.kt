package com.internshala.jalsahayfinal.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.internshala.jalsahayfinal.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //        LOGIN TO HOME PAGE
        val loginButton: Button = findViewById(R.id.btnLogin)
        loginButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        NO ACCOUNT TO SIGNUP
        val signUpTextView: TextView = findViewById(R.id.txtNoAccount)
        signUpTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}