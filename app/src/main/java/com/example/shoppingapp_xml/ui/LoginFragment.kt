package com.example.shoppingapp_xml.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.shoppingapp_xml.databinding.FragmentLoginBinding
import com.example.shoppingapp_xml.networkmodel.User
import com.example.shoppingapp_xml.viewmodel.UserViewModel
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UserViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            authenticate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun authenticate() {
        val email = binding.emailInput.text.toString()
        val password = binding.passwordInput2.text.toString()

        lifecycleScope.launch {
            userViewModel.login(user = User("mor_2314", "83r5^_"))
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please Enter", Toast.LENGTH_SHORT)
                    .show()
            }


        }


    }
}



