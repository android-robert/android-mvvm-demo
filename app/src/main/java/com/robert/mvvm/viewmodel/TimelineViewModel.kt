package com.robert.mvvm.viewmodel

import android.content.Context
import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.robert.mvvm.KeepApplication
import com.robert.mvvm.R
import com.robert.mvvm.data.PeopleFactory
import com.robert.mvvm.data.PeopleResponse
import com.robert.mvvm.model.People
import com.robert.mvvm.utils.LogUtils
import com.robert.mvvm.view.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import java.util.*


class TimelineViewModel(private val baseActivity: BaseActivity, val context: Context) : Observable() {
    var peopleProgress: ObservableInt = ObservableInt(View.GONE)
    var peopleRecycler: ObservableInt = ObservableInt(View.GONE)
    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    fun onClickNewPost(view: View) {
        //initializeViews()
        // next plan: build CreateNewPost feature
    }

    private fun initializeViews() {
        peopleRecycler.set(View.GONE)
        peopleProgress.set(View.VISIBLE)
    }

    fun reset() {
        compositeDisposable!!.dispose()
        compositeDisposable = null
    }

    init {
        initializeViews()
    }
}