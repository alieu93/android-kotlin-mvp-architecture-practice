package com.example.android_kotlin_mvp_architecture_practice.base

abstract class BasePresenter<V : BaseView> : MvpPresenter<V> {
    var view: V? = null

    override val isAttached = view != null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }
}