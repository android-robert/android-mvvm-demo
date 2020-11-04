package com.robert.mvvm.viewmodel

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.robert.mvvm.KeepApplication
import com.robert.mvvm.model.User
import com.robert.mvvm.utils.LogUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import com.robert.mvvm.BR;
import com.robert.mvvm.view.activities.MainActivity

class LoginViewModel(private val context: Context) : BaseObservable() {

    private val user: User = User("robert", "", "")
    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    @Bindable
    var toastMessage: String? = null
    set(value) {
        field = value
        notifyPropertyChanged(BR.toastMessage)
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
        val application: KeepApplication = KeepApplication.Companion.create(context)
        val keepService = application.keepService
        val disposable = keepService!!.login(user.keepId, null, null, null)
            .subscribeOn(application.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableObserver<com.robert.mvvm.data.response.User>() {

                override fun onStart() {
                    super.onStart()
                    //view.onShowLoadingDialog()
                }

                override fun onNext(response: com.robert.mvvm.data.response.User) {

                    if (response.status == null || response.status!!.not()) {
                        LogUtils.e("Loi roai.response.status=${response.status}")
                        toastMessage= errorMessage
                        return
                    }
                    LogUtils.i("Result.keepId=${response.result?.keepId}, userId=${response.result?.userId}, userName=${response.result?.userName}")

                    toastMessage = successMessage
                    startMainActivity()
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    //view.onHideLoadingDialog()
                }

                override fun onComplete() {
                    //view.onHideLoadingDialog()
                }
            })
        compositeDisposable!!.add(disposable)
    }

    fun startMainActivity() {
        context.startActivity(MainActivity.launch(context))
    }

    fun reset() {
        compositeDisposable!!.dispose()
        compositeDisposable = null
    }

}