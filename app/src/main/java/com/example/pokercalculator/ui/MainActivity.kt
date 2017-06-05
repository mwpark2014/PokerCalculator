package com.example.pokercalculator.ui

import android.content.Context
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
import com.example.pokercalculator.controller.Round
import android.view.inputmethod.InputMethodManager

//TODO: Create Poker Card Selector

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //This is the top right toolbar for settings found in activity_main.xml
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        //This is the EditText view that is used for input string
        val editTextBox = findViewById(R.id.inputTextField) as EditText
        editTextBox.setOnEditorActionListener {_, _, _ ->
            enterAction(editTextBox.getText().toString())}

        //This is the bottom right floating action button
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            run {
                val focus = this.currentFocus
                if (focus != null) {
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(focus.windowToken, 0)
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        }
        //TODO: Make it so virtual keyboard goes away when not in focus
        //TODO: Make it so virtual keyboard does not autocorrect
        //TODO: Create transition when typing in editfield
        //TODO: Ensure no memory leaks when activities and fragments are killed
    }

    private fun enterAction(input: String):Boolean {
        val round = Round(input)
        val arrayString = round.mHands.map {value -> value.toString()}
        Log.d(LOG_TAG, arrayString.reduce {total, f -> total + " " + f})
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
