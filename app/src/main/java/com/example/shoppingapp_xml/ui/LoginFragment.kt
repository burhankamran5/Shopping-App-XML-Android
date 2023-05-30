package com.example.shoppingapp_xml.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.shoppingapp_xml.databinding.FragmentLoginBinding
import com.example.shoppingapp_xml.networkmodel.User
import com.example.shoppingapp_xml.networkmodel.UserToken
import com.example.shoppingapp_xml.result.Result
import com.example.shoppingapp_xml.viewmodel.UserViewModel
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    var navController: NavController? = null
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
        binding.apply {
            lifecycleScope.launch {
                updateLoadState(true)
                userViewModel.login(user = User("mor_2314", "83r5^_"))
                    .collect { result ->
                        when (result) {
                            is Result.Success -> {
                                updateLoadState(false)
                                val data = result.data
                                if (data is UserToken) {
                                    Log.d(TAG, "authenticate: $data")
                                    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                                 findNavController().navigate(action)

                               } else {
                                    updateLoadState(false)
                                    Log.d(TAG, "authenticateError: $data")
                                }
                            }
                            else -> {
                            }
                        }

                    }


            }

        }


    }

    fun updateLoadState(isLoading: Boolean) {
        binding?.let {
            it.progressBar.isVisible = isLoading
            it.loginTxt.isVisible = !isLoading
        }
    }
}



