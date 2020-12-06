package com.example.android_kotlin_mvp_architecture_practice.main.contract

import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.base.BaseView

interface MainContract {
    interface Presenter : BasePresenter<View> {
        fun onClickNavigateToSecondFragmentButton()
    }

    interface View : BaseView {
        fun navigateToSecondFragment(numberOfTimesClicked: String)
    }
}