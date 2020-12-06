package com.example.android_kotlin_mvp_architecture_practice.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.main.contract.MainContract
import com.example.android_kotlin_mvp_architecture_practice.main.presenter.MainPresenter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : MainContract.View, Fragment() {
    private lateinit var mButtonFirst: Button
    private lateinit var mPresenter: MainContract.Presenter

    fun newInstance(presenter: MainContract.Presenter): FirstFragment {
        return FirstFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mButtonFirst = view.findViewById<Button>(R.id.button_first)
        mButtonFirst.setOnClickListener {
            mPresenter.onClickNavigateToSecondFragmentButton()
        }
    }

    override fun navigateToSecondFragment(numberOfTimesClicked: String) {
        mButtonFirst.text = mButtonFirst.text.toString().plus(" $numberOfTimesClicked")

        //TODO Creation of BaseFragment class for this kind of logic
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.nav_host_fragment, SecondFragment().newInstance())?.addToBackStack(this.toString())?.commit()
    }

    fun setPresenter(presenter: MainContract.Presenter) {
        this.mPresenter = presenter
    }
}