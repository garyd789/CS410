package com.example.geoquiz

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.geoquiz.databinding.ActivityMainBinding
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.activity.viewModels


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()



    private var messageResId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.questionTextView.setText(quizViewModel.currentQuestionText)

        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")




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
            quizViewModel.moveToNext()
            updateQuestion()
        }


        binding.previousButton.setOnClickListener {view ->
            quizViewModel.moveToPrev()
            updateQuestion()
        }

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
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    //function used to check answer
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer

        messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }




    }

}

