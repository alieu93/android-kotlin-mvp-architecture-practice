package com.example.android_kotlin_mvp_architecture_practice.addtodoitem.contract

import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter
import com.example.android_kotlin_mvp_architecture_practice.base.BaseView

interface AddToDoItemContract {
    interface Presenter : BasePresenter<View> {
        fun onSaveButtonClicked(description: String?, intentKey: String)
    }

    interface View : BaseView {
        fun saveToDoItem(description: String, intentKey: String)
        fun showValidationError()
    }
}