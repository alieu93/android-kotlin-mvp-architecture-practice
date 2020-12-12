package com.example.android_kotlin_mvp_architecture_practice.main.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.base.BaseActivity
import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.main.contract.ToDoContract
import com.example.android_kotlin_mvp_architecture_practice.main.presenter.ToDoPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class ToDoActivity : BaseActivity(), ToDoContract.View {
    override val layoutResource = R.layout.activity_main_to_do
    private lateinit var mPresenter: ToDoContract.Presenter
    private lateinit var mToDoFragment : ToDoFragment

    override fun initialize(state: Bundle?) {
        setSupportActionBar(findViewById(R.id.toolbar))
        initializeFragmentPresenter()
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        replaceFragmentTransaction(R.id.main_activity_fragment_container, mToDoFragment)
    }

    private fun initializeFragmentPresenter() {
        mPresenter = ToDoPresenter(this)
        mToDoFragment = ToDoFragment().newInstance()
        mToDoFragment.setPresenter(mPresenter)
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

    override fun showToDoList(dataSet: List<String>) {
        mToDoFragment.showToDoList(dataSet)
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }
}