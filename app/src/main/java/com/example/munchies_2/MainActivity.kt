package com.example.munchies_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep (3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.timeInput)
        suggestButton = findViewById(R.id.suggestButton)
        resetButton = findViewById(R.id.resetButton)

        suggestButton.setOnClickListener {
            suggestActivity()
        }

        resetButton.setOnClickListener {
            resetUI()
        }
    }

    private fun suggestActivity() {
        val inputText = inputEditText.text.toString().lowercase()

        val intent = when (inputText) {
            "morning" -> Intent(this, Morning::class.java)
            "mid morning" -> Intent(this, Mid_Morning::class.java)
            "afternoon" -> Intent(this, Afternoon::class.java)
            "mid afternoon" -> Intent(this, Mid_Afternoon::class.java)
            "dinner" -> Intent(this, dinner::class.java)
            else -> Intent(this, MainActivity::class.java)
        }

        startActivity(intent)
    }

    private fun resetUI() {
        inputEditText.text.clear() // Clear the EditText
        // Add more reset logic if needed (e.g., reset other UI elements)
    }
}