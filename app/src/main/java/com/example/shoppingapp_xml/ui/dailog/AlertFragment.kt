package com.example.shoppingapp_xml.ui.dailog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppingapp_xml.databinding.FragmentAlertBinding


class AlertFragment : DialogFragment() {

    private var _binding: FragmentAlertBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAlertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    binding.apply {
        message.text = "Are You Sure?"
        yesBtn.setText("Yes ")
        noBtn.setText("No")
        yesBtn.setOnClickListener {

        }
    }

    }
}
