package com.example.pokercalculator.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.example.pokercalculator.R
import com.example.pokercalculator.controller.ViewPagerAdapter

//TODO: Create Poker Card Selector

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewPager allows swiping left and right to navigate to different fragments
        val viewPagerAdapter = ViewPagerAdapter(getSupportFragmentManager(), this);
        val viewPager = findViewById(R.id.pager) as ViewPager;
        viewPager.setAdapter(viewPagerAdapter);

        //Add tabs with TabLayout for top navigation
        val tabLayout = findViewById(R.id.tab_layout) as TabLayout;
        tabLayout.setupWithViewPager(viewPager);

        //Set TabOnSelected Listener to facilitate clicking as well as swiping for nav
//        tabLayout.addOnTabSelectedListener{
//            tab -> viewPager.setCurrentItem(tab.getPosition())
//        }

        //This is the top right toolbar for settings found in activity_main.xml
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
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
        private const val TAG = "MainActivity"
    }
}
