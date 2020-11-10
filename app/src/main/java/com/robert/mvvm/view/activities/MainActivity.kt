package com.robert.mvvm.view.activities

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
import com.robert.mvvm.view.BaseFragment
import com.robert.mvvm.view.fragment.ChatFragment
import com.robert.mvvm.view.fragment.PeopleFragment
import com.robert.mvvm.view.fragment.SendFragment
import com.robert.mvvm.view.fragment.TimelineFragment

class MainActivity: BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var drawerLayout: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null
    private var bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.activity_main_drawer)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout?.addDrawerListener(drawerToggle!!)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation!!.setOnNavigationItemSelectedListener(bottomNavItemSelectedListener)

        navigationView = findViewById(R.id.nav_view)
        navigationView!!.setNavigationItemSelectedListener(this)
        if (savedInstanceState == null) {
            setSelectedFragment(R.id.nav_timeline, TimelineFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
        }
    }

    private var bottomNavItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener? = BottomNavigationView.OnNavigationItemSelectedListener {
        item -> return@OnNavigationItemSelectedListener onBottomNavigationItemSelected(item)
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

    fun setSelectedFragment(itemId: Int, fragment: BaseFragment, animation: Int) {
        changeFragment(fragment, animation)
        navigationView!!.setCheckedItem(itemId)
    }

    private fun onBottomNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                setSelectedFragment(R.id.nav_timeline, TimelineFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
                return true
            }
            R.id.navigation_sms -> {
                setSelectedFragment(R.id.nav_help, ChatFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
                return true
            }
            R.id.navigation_notifications -> {
                setSelectedFragment(R.id.nav_send, SendFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
                return true
            }
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_timeline -> setSelectedFragment(R.id.nav_timeline, TimelineFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
            R.id.nav_friends -> setSelectedFragment(R.id.nav_about, PeopleFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
            R.id.nav_help -> setSelectedFragment(R.id.nav_help, ChatFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
            R.id.nav_send -> setSelectedFragment(R.id.nav_send, SendFragment.newInstance(Bundle()), AppConst.ANIMATION_SLIDE_RIGHT_TO_LEFT)
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