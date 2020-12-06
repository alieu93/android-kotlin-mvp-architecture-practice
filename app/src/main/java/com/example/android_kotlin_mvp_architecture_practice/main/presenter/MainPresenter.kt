package com.example.android_kotlin_mvp_architecture_practice.main.presenter

import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.main.contract.MainContract

class MainPresenter(mainView: MainContract.View) : BasePresenter<MainContract.View>, MainContract.Presenter {
    private var mainView: MainContract.View? = mainView

    override val isAttached = getView() != null

    private var numberOfTimesNavigated:Int = 0

    override fun onClickNavigateToSecondFragmentButton() {
        numberOfTimesNavigated++
        mainView?.navigateToSecondFragment(numberOfTimesNavigated.toString())
    }

    override fun attachView(view: MainContract.View) {
        mainView = view
    }

    override fun detachView() {
        mainView = null
    }

    override fun getView(): MainContract.View? {
        return mainView
    }
}