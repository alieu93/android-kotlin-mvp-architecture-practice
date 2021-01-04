package com.example.android_kotlin_mvp_architecture_practice.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.addtodoitem.ui.AddToDoItemActivity
import com.example.android_kotlin_mvp_architecture_practice.main.contract.ToDoContract

class ToDoFragment : ToDoContract.View, Fragment() {
    private lateinit var mPresenter: ToDoContract.Presenter
    private lateinit var mToDoAdapter: ToDoAdapter
    private lateinit var mToDoRecyclerView: RecyclerView
    private lateinit var mToDoSet: MutableSet<String>

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

    private fun initializeRecyclerView(view: View) {
        mToDoRecyclerView = view.findViewById(R.id.to_do_recyclerview)
        mToDoRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mPresenter.showToDoList(mToDoSet.toList())
    }

    override fun showToDoList(dataSet: List<String>) {
        mToDoAdapter = ToDoAdapter(dataSet)
        mToDoRecyclerView.adapter = mToDoAdapter
        mToDoAdapter.notifyDataSetChanged()
    }


    override fun goToAddNewToDoItemActivity(activityRequestCode: Int) {
        startActivityForResult(Intent(activity, AddToDoItemActivity::class.java), activityRequestCode)
    }

    fun setPresenter(presenter: ToDoContract.Presenter) {
        this.mPresenter = presenter
    }

    fun setToDoSet(toDoSet: MutableSet<String>) {
        this.mToDoSet = toDoSet
    }
}