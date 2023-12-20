package com.internshala.jalsahayfinal.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.internshala.jalsahayfinal.R

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
//            val selectedRadioButton = findViewById<RadioButton>(checkedId)
//            showToast("Selected Option: ${selectedRadioButton.text}")
            // Handle the checkedId
            when (checkedId) {
                R.id.button1 -> {
                    // Option 1 is selected
                    showToast("Potholes")
                }

                R.id.button2 -> {
                    // Option 2 is selected
                    showToast("Floods")
                }

                R.id.button3 -> {
                    // Option 2 is selected
                    showToast("Drainage")
                }

                R.id.button4 -> {
                    // Option 2 is selected
                    showToast("Pipe Leakage")
                }
            }
        }
    }
        private fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        }
    }