package com.example.homework1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SquareActivity : AppCompatActivity() {

    companion object{
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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)
        squareTextView = findViewById(R.id.square_text_view)
        number = intent.getIntExtra(SQUARE_NUMBER_KEY, 0)
        squareTextView.text = (number * number).toString()
    }
}