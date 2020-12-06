package com.example.android_kotlin_mvp_architecture_practice.main.ui

import android.R.attr.fragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.base.BaseActivity
import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.main.contract.MainContract
import com.example.android_kotlin_mvp_architecture_practice.main.presenter.MainPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : BaseActivity(), MainContract.View {
    override val layoutResource = R.layout.activity_main
    private lateinit var mPresenter: MainContract.Presenter
    private lateinit var mFirstFragment : FirstFragment

    override fun initialize(state: Bundle?) {
        setSupportActionBar(findViewById(R.id.toolbar))
        mPresenter = MainPresenter(this)
        mFirstFragment = FirstFragment().newInstance(mPresenter)
        mFirstFragment.setPresenter(mPresenter)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //TODO Generic method in BaseActivity? for this sort of logic
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, mFirstFragment)
        transaction.commit()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun navigateToSecondFragment(numberOfTimesClicked: String) {
        mFirstFragment.navigateToSecondFragment(numberOfTimesClicked)
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }
}