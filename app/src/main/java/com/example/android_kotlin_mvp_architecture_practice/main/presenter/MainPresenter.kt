package com.example.android_kotlin_mvp_architecture_practice.main.presenter

import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.base.BaseView
import com.example.android_kotlin_mvp_architecture_practice.main.contract.MainContract

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun onViewCreated() {
        //TODO("Not yet implemented, do nothing at the moment")
    }
}