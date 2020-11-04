package com.robert.mvvm.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.robert.mvvm.R
import com.robert.mvvm.databinding.ActivityMainBinding
import com.robert.mvvm.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding?.viewModel = LoginViewModel(this)
        activityMainBinding?.executePendingBindings()
    }
}

@BindingAdapter("toastMessage")
fun onLoginResult(view: View, message: String?) {
    if (message != null) Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
}