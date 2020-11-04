package com.robert.mvvm.view.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.robert.mvvm.R
import com.robert.mvvm.view.fragment.*

class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var drawer: DrawerLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer!!.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MessageFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_message)
        }
    }

    @SuppressLint("NonConstantResourceId")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_message -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MessageFragment()).commit()
            R.id.nav_chat -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ChatFragment()).commit()
            R.id.nav_profile -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ProfileFragment()).commit()
            R.id.nav_share -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ShareFragment()).commit()
            R.id.nav_send -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SendFragment()).commit()
        }
        drawer!!.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        fun launch(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}