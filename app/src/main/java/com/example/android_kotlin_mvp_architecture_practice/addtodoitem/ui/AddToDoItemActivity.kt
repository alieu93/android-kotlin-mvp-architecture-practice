package com.example.android_kotlin_mvp_architecture_practice.addtodoitem.ui

import android.os.Bundle
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.addtodoitem.contract.AddToDoItemContract
import com.example.android_kotlin_mvp_architecture_practice.addtodoitem.presenter.AddToDoItemPresenter
import com.example.android_kotlin_mvp_architecture_practice.base.BaseActivity
import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter

class AddToDoItemActivity : BaseActivity(), AddToDoItemContract.View {
    override val layoutResource = R.layout.activity_add_to_do_item
    private lateinit var mPresenter: AddToDoItemContract.Presenter
    private lateinit var mAddToDoFragment: AddToDoItemFragment

    override fun initialize(state: Bundle?) {
        initializeFragmentPresenter()
        replaceFragmentTransaction(R.id.add_to_do_activity_fragment_container, mAddToDoFragment)
    }

    private fun initializeFragmentPresenter() {
        mPresenter = AddToDoItemPresenter(this)
        mAddToDoFragment = AddToDoItemFragment().newInstance()
        mAddToDoFragment.setPresenter(mPresenter)
    }

    override fun saveToDoItem(description: String, intentKey: String) {
        mAddToDoFragment.saveToDoItem(description, intentKey)
    }

    override fun showValidationError() {
        mAddToDoFragment.showValidationError()
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }
}