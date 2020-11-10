package com.robert.mvvm.view.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.robert.mvvm.R
import com.robert.mvvm.constant.AppConst
import com.robert.mvvm.view.BaseActivity
import com.robert.mvvm.view.fragment.ChatFragment
import com.robert.mvvm.view.fragment.PeopleFragment
import com.robert.mvvm.view.fragment.SendFragment

class MainActivity: BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var drawerLayout: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null
    private var bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.activity_main_drawer)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout?.addDrawerListener(drawerToggle!!)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        bottomNavigation = findViewById<BottomNavigationView?>(R.id.bottom_navigation)
        bottomNavigation!!.setOnNavigationItemSelectedListener(navigationItemSelectedListener)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, PeopleFragment.newInstance(Bundle())).commit()
            navigationView.setCheckedItem(R.id.nav_about)
        }
    }

    private var navigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener? = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                changeFragment(PeopleFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sms -> {
                changeFragment(ChatFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                changeFragment(SendFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle!!.onConfigurationChanged(newConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    @SuppressLint("NonConstantResourceId")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_about -> changeFragment(PeopleFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
            R.id.nav_help -> changeFragment(ChatFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
            R.id.nav_send -> changeFragment(SendFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
        }
        drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle!!.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            R.id.search -> {
                Toast.makeText(this, "Search button selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.about -> {
                Toast.makeText(this, "About button selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.help -> {
                Toast.makeText(this, "Help button selected", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun launch(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

}