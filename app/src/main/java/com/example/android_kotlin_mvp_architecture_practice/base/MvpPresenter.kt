package com.example.android_kotlin_mvp_architecture_practice.base

interface MvpPresenter<V : BaseView> {
    val isAttached: Boolean

    fun attachView(view: V)

    fun detachView()
}