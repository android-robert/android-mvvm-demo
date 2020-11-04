package com.robert.mvvm

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.robert.mvvm.data.PeopleFactory
import com.robert.mvvm.data.PeopleService
import com.robert.mvvm.data.api.KeepApiService
import com.robert.mvvm.data.factory.KeepFactory
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class KeepApplication : MultiDexApplication() {

    var keepService: KeepApiService? = null
        get() {
            if (field == null) {
                field = KeepFactory.create()
            }
            return field
        }

    var peopleService: PeopleService? = null
        get() {
            if (field == null) {
                field = PeopleFactory.create()
            }
            return field
        }
    private var scheduler: Scheduler? = null

    fun subscribeScheduler(): Scheduler {
        if (scheduler == null) {
            scheduler = Schedulers.io()
        }
        return scheduler!!
    }

    companion object {
        private operator fun get(context: Context?): KeepApplication {
            return context!!.applicationContext as KeepApplication
        }

        fun create(context: Context?): KeepApplication {
            return get(context)
        }
    }
}