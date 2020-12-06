package com.example.android_kotlin_mvp_architecture_practice.presenter

import com.example.android_kotlin_mvp_architecture_practice.main.contract.MainContract
import com.example.android_kotlin_mvp_architecture_practice.main.presenter.MainPresenter
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class MainPresenterTest {
    private val mainView: MainContract.View = mock(MainContract.View::class.java)

    private var mPresenter: MainPresenter? = null

    @Before
    fun setUp() {
        initMocks(this)
        mPresenter = MainPresenter(mainView)
    }


    @Test
    fun onClickNavigateToSecondFragmentButton() {
        assertDoesNotThrow {
            mPresenter?.onClickNavigateToSecondFragmentButton()
        }
        verify(mainView).navigateToSecondFragment("1")
    }

    @Test
    fun isViewAttached() {
        //mPresenter?.attachView(mainView)
        mPresenter?.let { assert(it.isAttached).equals(true) }
    }

    @Test
    fun isViewDetached() {
        mPresenter?.detachView()
        mPresenter?.let { assert(it.isAttached).equals(false) }
    }
}