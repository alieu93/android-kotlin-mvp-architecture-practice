package com.example.android_kotlin_mvp_architecture_practice.presenter

import com.example.android_kotlin_mvp_architecture_practice.main.contract.ToDoContract
import com.example.android_kotlin_mvp_architecture_practice.main.presenter.ToDoPresenter
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class ToDoPresenterTest {
    private val mainView: ToDoContract.View = mock(ToDoContract.View::class.java)

    private var mPresenter: ToDoPresenter? = null

    @Before
    fun setUp() {
        initMocks(this)
        mPresenter = ToDoPresenter(mainView)
    }


    @Test
    fun initializeList() {
        assertDoesNotThrow {
            mPresenter?.showToDoList(DATA_SET_LIST)
        }
        verify(mainView).showToDoList(DATA_SET_LIST)
    }

    @Test
    fun isViewAttached() {
        mPresenter?.let { assert(it.isAttached).equals(true) }
    }

    @Test
    fun isViewDetached() {
        mPresenter?.detachView()
        mPresenter?.let { assert(it.isAttached).equals(false) }
    }

    companion object {
        val DATA_SET_LIST = listOf("Test1", "Test2")
    }
}