package com.example.expert.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.expert.R
import kotlinx.android.synthetic.main.fragment_delete.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DeleteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DeleteFragment : DialogFragment(), View.OnClickListener {

    companion object {
        var EXTRA_DATA = "extra_data"
    }

    private var data: String? = null
    private var listener: OnDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        data = arguments?.getString(EXTRA_DATA)
        textdelete.text = resources.getString(R.string.delete_fav, data)
        yesb.setOnClickListener(this)
        nob.setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogListener
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnDialogListener {
        fun ondelete(text: String)
    }

    override fun onClick(view: View?) {
        when (view) {
            yesb -> {
                listener?.ondelete("Delete")
                dialog?.dismiss()
            }
            nob -> {
                listener?.ondelete("Canceled")
                dialog?.dismiss()
            }
        }
    }
}