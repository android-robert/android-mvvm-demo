package com.robert.mvvm.view.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.robert.mvvm.R
import com.robert.mvvm.view.BaseActivity

class ForgotPasswordActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { super.onBackPressed() }
        setStatusBarWhite(this@ForgotPasswordActivity)
    }

    companion object {
        fun launch(context: Context): Intent {
            return Intent(context, ForgotPasswordActivity::class.java)
        }
    }
}
