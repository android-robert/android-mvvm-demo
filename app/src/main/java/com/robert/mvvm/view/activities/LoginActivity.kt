package com.robert.mvvm.view.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.robert.mvvm.R
import com.robert.mvvm.databinding.ActivityLoginBinding
import com.robert.mvvm.view.BaseActivity
import com.robert.mvvm.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity() {
    private var activityMainBinding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityMainBinding?.viewModel = LoginViewModel(this, this)
        activityMainBinding?.executePendingBindings()

        setStatusBarTransparent(this@LoginActivity)
    }
}

@BindingAdapter("toastMessage")
fun onLoginResult(view: View, message: String?) {
    message?.let {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("usernameMessage")
fun onUsernameValidation(view: View, message: String?) {
    message?.let {
        if (view is TextInputEditText) {
            view.error = it
        }
    }
}

@BindingAdapter("passwordMessage")
fun onPasswordValidation(view: View, message: String?) {
    message?.let {
        if (view is TextInputEditText) {//if (view is TextInputLayout) {
            view.error = it
        }
    }
}