package com.example.android_kotlin_mvp_architecture_practice.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.main.contract.ToDoContract

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ToDoFragment : ToDoContract.View, Fragment() {
    private lateinit var mPresenter: ToDoContract.Presenter
    private lateinit var mToDoAdapter: ToDoAdapter
    private lateinit var mToDoRecyclerView: RecyclerView

    fun newInstance(): ToDoFragment {
        return ToDoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView(view)
    }

    private fun initializeMockList(): List<String> {
        return listOf("Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7", "Test8", "Test9", "Test10",
                "Test11", "Test12", "Test13", "Test14", "Test15", "Test16", "Test17", "Test18", "Test19", "Test20")
    }

    private fun initializeRecyclerView(view: View) {
        mToDoRecyclerView = view.findViewById(R.id.to_do_recyclerview)
        mToDoRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mPresenter.initializeToDoList(initializeMockList())
    }

    override fun showToDoList(dataSet: List<String>) {
        mToDoAdapter = ToDoAdapter(dataSet)
        mToDoRecyclerView.adapter = mToDoAdapter
        mToDoAdapter.notifyDataSetChanged()
    }

    fun setPresenter(presenter: ToDoContract.Presenter) {
        this.mPresenter = presenter
    }
}