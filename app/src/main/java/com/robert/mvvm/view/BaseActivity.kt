package com.robert.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robert.mvvm.R
import com.robert.mvvm.utils.LogUtils

open class BaseActivity: AppCompatActivity(), BaseFragment.ChangeFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.i(this.javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        LogUtils.v(this.javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        LogUtils.i(this.javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        LogUtils.i(this.javaClass.simpleName)
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.i(this.javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        LogUtils.i(this.javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.i(this.javaClass.simpleName)
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        LogUtils.i(this.javaClass.simpleName)
    }

    override fun changeFragment(fragment: BaseFragment, animation: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    override fun replaceFragment(fragment: BaseFragment, animation: Int, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment, tag)
        transaction.addToBackStack(fragment.CURR_FRAGMENT_TAG)
        transaction.commit()
    }

    override fun popBackStackInclusiveFragment(stackName: String) {
        TODO("Not yet implemented")
    }

    override fun popBackStackFragment(stackName: String) {
        TODO("Not yet implemented")
    }
}
