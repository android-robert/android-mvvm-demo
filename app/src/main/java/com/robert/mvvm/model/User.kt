package com.robert.mvvm.model

import android.text.TextUtils
import android.util.Patterns

class User(var keepId: String, var email: String, var password: String) {

    val isInputDataValid: Boolean
        get() = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 5

}