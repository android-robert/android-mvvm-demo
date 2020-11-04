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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import java.util.*


class PeopleViewModel(val context: Context) : Observable() {
    var peopleProgress: ObservableInt
    var peopleRecycler: ObservableInt
    var peopleLabel: ObservableInt
    var messageLabel: ObservableField<String>
    var peopleList = ObservableArrayList<People>()
    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    fun onClickFabLoad(view: View?) {
        initializeViews()
        fetchPeopleList()
    }

    //It is "public" to show an example of test
    private fun initializeViews() {
        peopleLabel.set(View.GONE)
        peopleRecycler.set(View.GONE)
        peopleProgress.set(View.VISIBLE)
    }

    // NOTE: This method can return the rx observer and just subscribe to it in the activity or fragment,
    // an Activity or Fragment needn't to implement from the Observer java class
    // (it was my first approach to avoid RX in UI now we can use LiveData instead)
    private fun fetchPeopleList() {
        val application = KeepApplication.create(context)
        val peopleService = application.peopleService
        val disposable = peopleService!!.fetchPeople(PeopleFactory.RANDOM_USER_URL)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<PeopleResponse>() {

                    override fun onStart() {
                        super.onStart()
                        //view.onShowLoadingDialog()
                        LogUtils.e("onStart is calling...")
                    }

                    override fun onNext(response: PeopleResponse) {
                        LogUtils.e("onNext is calling...")

                        peopleProgress.set(View.GONE)
                        peopleLabel.set(View.GONE)
                        peopleRecycler.set(View.VISIBLE)

                        response.peopleList?.let { peopleList->
                            if (peopleList.isEmpty()) {
                                LogUtils.e("No Data")
                            }  else {
                                LogUtils.e("peopleList.size=${peopleList.size}")
                                changePeopleDataSet(peopleList)
                            }
                        }?: kotlin.run {
                            LogUtils.e("Loi roai.response is null")
                        }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        //view.onHideLoadingDialog()
                        LogUtils.e("onError is calling...")
                        messageLabel.set(context.getString(R.string.error_loading_people))
                        peopleProgress.set(View.GONE)
                        peopleLabel.set(View.VISIBLE)
                        peopleRecycler.set(View.GONE)
                    }

                    override fun onComplete() {
                        //view.onHideLoadingDialog()
                        LogUtils.e("onComplete is calling...")
                    }
                })
        compositeDisposable!!.add(disposable)
    }

    private fun changePeopleDataSet(peoples: List<People>) {
        peopleList.addAll(peoples)
        LogUtils.e("--->peopleList.size=${peopleList.size}")
        setChanged()
        notifyObservers(peopleList)
    }

    fun reset() {
        compositeDisposable!!.dispose()
        compositeDisposable = null
    }

    init {
        peopleProgress = ObservableInt(View.GONE)
        peopleRecycler = ObservableInt(View.GONE)
        peopleLabel = ObservableInt(View.VISIBLE)
        messageLabel = ObservableField(context.getString(R.string.default_loading_people))

        initializeViews()
        fetchPeopleList()
    }
}