package com.example.android_kotlin_mvp_architecture_practice.addtodoitem.ui

import android.app.Activity
import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.android_kotlin_mvp_architecture_practice.R
import com.example.android_kotlin_mvp_architecture_practice.addtodoitem.contract.AddToDoItemContract
import com.google.android.material.textfield.TextInputEditText

class AddToDoItemFragment :  AddToDoItemContract.View, Fragment() {
    private lateinit var mPresenter: AddToDoItemContract.Presenter
    private lateinit var mAddToDoItemEditText: TextInputEditText
    private lateinit var mSaveToDoItemButton: Button

    fun newInstance(): AddToDoItemFragment {
        return AddToDoItemFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_to_do_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAddToDoItemEditText = view.findViewById(R.id.add_to_do_item_text_input_edit_text)
        mSaveToDoItemButton = view.findViewById(R.id.save_to_do_item_button)

        mSaveToDoItemButton.setOnClickListener {
            mPresenter.onSaveButtonClicked(mAddToDoItemEditText.text?.toString(), ADD_TO_DO_ITEM_KEY)
        }

        mAddToDoItemEditText.addTextChangedListener {
            mAddToDoItemEditText.error = null
        }
    }

    override fun saveToDoItem(description: String, intentKey: String) {
        val intent = Intent().putExtra(intentKey, description)
        activity?.setResult(Activity.RESULT_OK, intent)
        activity?.finish()
    }

    override fun showValidationError() {
        mAddToDoItemEditText.error = "Please enter a new task!"
        mAddToDoItemEditText.requestFocus()
    }

    fun setPresenter(presenter: AddToDoItemContract.Presenter) {
        this.mPresenter = presenter
    }

    companion object {
        const val ADD_TO_DO_ITEM_KEY = "ADD_TO_DO_ITEM_KEY"
    }
}