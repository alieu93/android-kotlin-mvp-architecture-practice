package com.example.android_kotlin_mvp_architecture_practice.main.contract

import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.base.BaseView

interface ToDoContract {
    interface Presenter : BasePresenter<View> {
        fun initializeToDoList(dataSet: List<String>)
    }

    interface View : BaseView {
        fun showToDoList(dataSet: List<String>)
    }
}