package com.example.geoquiz

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.geoquiz.databinding.ActivityMainBinding
import android.util.Log
import com.google.android.material.snackbar.Snackbar


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0
    private var messageResId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Toasts
        binding.trueButton.setOnClickListener { view: View ->
            // Do something in response to the click here
           checkAnswer(true)
            Snackbar.make(view, messageResId, Snackbar.LENGTH_SHORT).show()
        }

        binding.falseButton.setOnClickListener { view: View ->
            // Do something in response to the click here
           checkAnswer(false)
            Snackbar.make(view, messageResId, Snackbar.LENGTH_SHORT).show()

        }

        //Makes the next button functional
        binding.nextButton.setOnClickListener { view ->
            currentIndex = (currentIndex + 1) % questionBank.size //makes the question wrap around
            updateQuestion()

        }

        //Makes the prev button functional
        binding.previousButton.setOnClickListener { view ->
            currentIndex = (currentIndex + questionBank.size - 1) % questionBank.size //makes the question wrap around
            updateQuestion()

        }

        updateQuestion()

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }


    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    //function used to check answer
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }




    }

}

