package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    private lateinit var helloButton: Button
    private lateinit var mainText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloButton = findViewById(R.id.hello_button)
        mainText = findViewById(R.id.main_text)


        helloButton.setOnClickListener { view: View ->
            // Do something in response to the click here
            Toast.makeText(
                this,
                R.string.hello_toast,
                Toast.LENGTH_SHORT
            ).show()

            //Set text
            mainText.setText("Hello! :)")

        }

    } }
