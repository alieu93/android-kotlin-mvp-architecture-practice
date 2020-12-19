package com.example.android_kotlin_mvp_architecture_practice.addtodoitem.presenter

import com.example.android_kotlin_mvp_architecture_practice.addtodoitem.contract.AddToDoItemContract
import com.example.android_kotlin_mvp_architecture_practice.base.BasePresenter

class AddToDoItemPresenter(mainView: AddToDoItemContract.View) : BasePresenter<AddToDoItemContract.View>, AddToDoItemContract.Presenter {
    private var mainView: AddToDoItemContract.View? = mainView

    override val isAttached = getView() != null

    override fun onSaveButtonClicked(description: String?, intentKey: String) {
        if(description != null && description.isNotEmpty()) {
            mainView?.saveToDoItem(description, intentKey)
        } else {
            mainView?.showValidationError()
        }
    }

    override fun attachView(view: AddToDoItemContract.View) {
        mainView = view
    }

    override fun detachView() {
        mainView = null
    }

    override fun getView(): AddToDoItemContract.View? {
        return mainView
    }
}