package com.example.pokercalculator.ui

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.example.pokercalculator.R
import com.example.pokercalculator.model.Round

class MainActivity : AppCompatActivity() {
    //TODO: Add fragment? for ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val editTextBox = findViewById(R.id.inputTextField) as EditText;
        editTextBox.setOnEditorActionListener {v, actionId, event ->
            enterAction(editTextBox.getText().toString())}
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun enterAction(input: String):Boolean {
        val round = Round(input);
        val arrayString = round.mHands.map {value -> value.toString()}
        Log.i(LOG_TAG, arrayString.reduce {total, f -> total + " " + f})
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val LOG_TAG = "MainActivity tag:"
    }
}
