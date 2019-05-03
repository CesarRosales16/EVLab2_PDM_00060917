package com.example.corto2_00060917

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_btn.*
import kotlinx.android.synthetic.main.fragment_btn.view.*


val ARG_ACTION_1: String = "action_1"
val ARG_ACTION_2: String = "action_2"

class FakeBarFragment : Fragment() {

    var listener: OnSelectOption? = null
    private var action1: String? = null
    private var action2: String? = null


    companion object {

        fun newInstace(action1: String, action2: String) =
            FakeBarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ACTION_1, action1)
                    putString(ARG_ACTION_2, action2)

                }
            }
    }

    interface OnSelectOption {
        fun onAction(id: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSelectOption) {
            listener = context
        } else {
            throw RuntimeException("Se necesita una implementación de  OnSelectOption")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            action1 = getString(ARG_ACTION_1)
            action2 = getString(ARG_ACTION_2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_btn,container,false)
        view.btn_previous.apply {
            text = action1
            setOnClickListener {
                listener?.onAction(1)
            }
        }
        view.btn_forward.apply {
            text = action2
            setOnClickListener {
                listener?.onAction(2)
            }
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}

