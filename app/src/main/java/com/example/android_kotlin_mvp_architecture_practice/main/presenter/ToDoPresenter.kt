package com.example.android_kotlin_mvp_architecture_practice.main.presenter

import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.main.contract.ToDoContract

class ToDoPresenter(mainView: ToDoContract.View) : BasePresenter<ToDoContract.View>, ToDoContract.Presenter {
    private var mainView: ToDoContract.View? = mainView

    override val isAttached = getView() != null

    override fun initializeToDoList(dataSet: List<String>) {
        mainView?.showToDoList(dataSet)
    }

    override fun attachView(view: ToDoContract.View) {
        mainView = view
    }

    override fun detachView() {
        mainView = null
    }

    override fun getView(): ToDoContract.View? {
        return mainView
    }
}