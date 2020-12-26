package com.example.android_kotlin_mvp_architecture_practice.main.ui

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.base.BaseActivity
import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.main.contract.ToDoContract
import com.example.android_kotlin_mvp_architecture_practice.main.presenter.ToDoPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ToDoActivity : BaseActivity(), ToDoContract.View {
    override val layoutResource = R.layout.activity_main_to_do
    private lateinit var mPresenter: ToDoContract.Presenter
    private lateinit var mToDoFragment : ToDoFragment
    private lateinit var mToDoSet: MutableSet<String>

    override fun initialize(state: Bundle?) {
        //TODO load shared preference, remove this when it is implemented (initialize mutableSet if no existing set is found)
        mToDoSet = mutableSetOf()

        setSupportActionBar(findViewById(R.id.toolbar))
        initializeFragmentPresenter()
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            mPresenter.onClickAddNewToDoItemFab(ADD_TO_DO_ITEM_REQUEST_CODE)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == ADD_TO_DO_ITEM_REQUEST_CODE) {
            /** Append to set and save item to persist in SharedPreferences, remove toast when it is implemented
             *  ToDoActivity will control Set of TODOs, initialize set at onCreate and subsequent new appends are done here
             *  Presenter will be invoked in order to update the list with new entry and call recyclerView to update accordingly
             **/

            Toast.makeText(applicationContext, "" + data?.getStringExtra(ADD_TO_DO_ITEM_KEY), Toast.LENGTH_SHORT).show()
            if (data != null) {
                data.getStringExtra(ADD_TO_DO_ITEM_KEY)?.let { mToDoSet.add(it) }
            }
        }
    }

    override fun showToDoList(dataSet: List<String>) {
        mToDoFragment.showToDoList(dataSet)
    }

    override fun goToAddNewToDoItemActivity(activityRequestCode: Int) {
        mToDoFragment.goToAddNewToDoItemActivity(activityRequestCode)
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    companion object {
        private const val ADD_TO_DO_ITEM_REQUEST_CODE = 30
        private const val ADD_TO_DO_ITEM_KEY = "ADD_TO_DO_ITEM_KEY"
    }
}