package com.example.android_kotlin_mvp_architecture_practice.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.io.Serializable

abstract class BaseActivity : AppCompatActivity(), BaseView {
    private lateinit var mPresenter: BasePresenter<*>
    private val INTENT_KEY_ARG_DATA = "ARG_DATA"

    //Resource Id of the layout
    @get:LayoutRes
    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        initialize(savedInstanceState)
    }

    protected abstract fun initialize(state: Bundle?)

    protected fun <T : Serializable> getArgData(): T {
        return intent.getSerializableExtra(INTENT_KEY_ARG_DATA) as T
    }

    abstract fun getPresenter(): BasePresenter<*>

    protected fun replaceFragmentTransaction(containerViewId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(containerViewId, fragment).commit()
    }
}