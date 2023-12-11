package com.internshala.jalsahayfinal.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.internshala.jalsahayfinal.R

class UserEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_employee)
//        USER LOGIN BUTTON CLICK
        val userLoginButton: Button = findViewById(R.id.btnUserLogin)
        userLoginButton.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

//        EMPLOYEE LOGIN BUTTON CLICK
        val employeeLoginButton: Button = findViewById(R.id.btnEmployeeLogin)
        employeeLoginButton.setOnClickListener{
            val intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
        }
    }
}