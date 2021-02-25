package com.example.homework1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ConfChangesCounterActivity : AppCompatActivity() {

    companion object{
        const val ACTIVITY_NAME = "ConfigChangedCounter"
        const val CHANGES_VALUE_KEY = "changes key"
    }

    lateinit var confChangesTextView: TextView
    lateinit var squareButton: Button
    var configurationChangesCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(ACTIVITY_NAME, "On start create activity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        confChangesTextView = findViewById(R.id.config_changes_output_text_view)
        squareButton = findViewById(R.id.button_look_square)
        squareButton.setOnClickListener {
            val intent = SquareActivity.newIntent(this, configurationChangesCounter)
            startActivity(intent)
        }
    }

    override fun onResume() {
        Log.d(ACTIVITY_NAME, "On resume")
        super.onResume()
        confChangesTextView.text = configurationChangesCounter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(ACTIVITY_NAME, "On save instance state")
        super.onSaveInstanceState(outState)
        outState.putInt(CHANGES_VALUE_KEY, configurationChangesCounter + 1)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(ACTIVITY_NAME, "On restore instance state")
        super.onRestoreInstanceState(savedInstanceState)
        configurationChangesCounter = savedInstanceState.getInt(CHANGES_VALUE_KEY)
    }

    override fun onDestroy() {
        Log.d(ACTIVITY_NAME, "On destroy")
        super.onDestroy()
    }
}