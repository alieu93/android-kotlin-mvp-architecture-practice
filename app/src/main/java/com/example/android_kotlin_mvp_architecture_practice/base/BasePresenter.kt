package com.example.android_kotlin_mvp_architecture_practice.base

interface BasePresenter<V : BaseView> {
    val isAttached: Boolean

    fun attachView(view: V)

    fun detachView()

    fun getView() : V?
}