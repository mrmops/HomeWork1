package com.example.homework1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SquareActivity : AppCompatActivity() {

    companion object{
        val LOG_KEY = SquareActivity::class.java.simpleName

        const val SQUARE_NUMBER_KEY = "Number key"

        fun newIntent(context: Context, number: Int): Intent{
            val intent = Intent(context, SquareActivity::class.java).apply {
                putExtra(SQUARE_NUMBER_KEY, number)
            }
            return intent
        }
    }

    lateinit var squareTextView: TextView
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_KEY, "On create")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)
        squareTextView = findViewById(R.id.square_text_view)
        val extras = intent.extras
        if(extras != null) {
            number = extras.getInt(SQUARE_NUMBER_KEY)
            squareTextView.text = (number * number).toString()
        }
        else{
            throw IllegalArgumentException()
        }
    }
}