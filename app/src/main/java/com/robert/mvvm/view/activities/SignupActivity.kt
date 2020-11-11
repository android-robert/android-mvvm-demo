package com.robert.mvvm.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.robert.mvvm.R
import com.robert.mvvm.view.BaseActivity

class SignupActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { super.onBackPressed() }
        setStatusBarWhite(this@SignupActivity)
    }

    companion object {
        fun launch(context: Context): Intent {
            return Intent(context, SignupActivity::class.java)
        }
    }
}
