package com.robert.mvvm.viewmodel

import android.content.Context
import android.view.View
import android.view.WindowManager
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableInt
import com.robert.mvvm.BR
import com.robert.mvvm.KeepApplication
import com.robert.mvvm.R
import com.robert.mvvm.model.User
import com.robert.mvvm.utils.KeyboardUtils
import com.robert.mvvm.utils.LogUtils
import com.robert.mvvm.view.BaseActivity
import com.robert.mvvm.view.activities.ForgotPasswordActivity
import com.robert.mvvm.view.activities.MainActivity
import com.robert.mvvm.view.activities.SignupActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver


class LoginViewModel(private val baseActivity: BaseActivity, private val context: Context) : BaseObservable() {

    var loginProgress: ObservableInt = ObservableInt(View.GONE)
    private val user: User = User("", "", "")
    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    @Bindable
    var toastMessage: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.toastMessage)
        }

    @Bindable
    var usernameMessage: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.usernameMessage)
        }

    @Bindable
    var passwordMessage: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.passwordMessage)
        }

    fun afterKeepIdTextChanged(s: CharSequence) {
        user.keepId = s.toString()
    }

    fun afterEmailTextChanged(s: CharSequence) {
        user.email = s.toString()
    }

    fun afterPasswordTextChanged(s: CharSequence) {
        user.password = s.toString()
    }

    fun onLoginClicked() {
        KeyboardUtils.hideSoftKeyboard(context)

        if (isValidate()) {
            loginSubmit()
        }
    }

    fun loginSubmit() {

        val application: KeepApplication = KeepApplication.Companion.create(context)
        val keepService = application.keepService
        val disposable = keepService!!.login(user.keepId, null, null, null)
            .subscribeOn(application.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<com.robert.mvvm.data.response.User>() {

                override fun onStart() {
                    super.onStart()
                    showProgressBar()
                }

                override fun onNext(response: com.robert.mvvm.data.response.User) {

                    if (response.status == null || response.status!!.not()) {
                        LogUtils.e("Loi roai.response.status=${response.status}")
                        toastMessage = context.getString(R.string.login_fail)
                        return
                    }
                    LogUtils.i("Result.keepId=${response.result?.keepId}, userId=${response.result?.userId}, userName=${response.result?.userName}")

                    toastMessage = context.getString(R.string.login_successful)
                    startMainActivity()
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    dismissProgressBar()
                }

                override fun onComplete() {
                    dismissProgressBar()
                }
            })
        compositeDisposable!!.add(disposable)
    }

    private fun isValidate(): Boolean {
        var isValidate = true
        if (user.keepId.isEmpty() || user.keepId.isBlank()) {
            usernameMessage = context.getString(R.string.username_not_empty)
            isValidate = false
        }

        if (user.password.isEmpty() || user.password.isBlank()) {
            passwordMessage = context.getString(R.string.password_not_empty)
            isValidate = false
        }
        return isValidate
    }

    fun showProgressBar() {
        loginProgress.set(View.VISIBLE)
        baseActivity.window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    fun dismissProgressBar() {
        loginProgress.set(View.GONE)
        baseActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    fun onSignupClicked() {
        context.startActivity(SignupActivity.launch(context))
    }

    fun onForgotPasswordClicked() {
        context.startActivity(ForgotPasswordActivity.launch(context))
    }

    fun startMainActivity() {
        baseActivity.finish()
        context.startActivity(MainActivity.launch(context))
    }

    fun reset() {
        compositeDisposable!!.dispose()
        compositeDisposable = null
    }

}