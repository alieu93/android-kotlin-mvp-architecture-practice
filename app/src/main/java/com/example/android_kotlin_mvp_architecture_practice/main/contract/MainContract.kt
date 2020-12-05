package com.example.android_kotlin_mvp_architecture_practice.main.contract

import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.base.BaseView
import com.example.android_kotlin_mvp_architecture_practice.base.MvpPresenter

interface MainContract {
    interface Presenter : MvpPresenter<View> {
        fun onViewCreated()
    }

    interface View : BaseView {

    }
}