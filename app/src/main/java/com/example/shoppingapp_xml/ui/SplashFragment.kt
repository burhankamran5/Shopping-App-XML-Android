package com.example.shoppingapp_xml.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.shoppingapp_xml.R
import com.example.shoppingapp_xml.databinding.FragmentSplashBinding
import com.example.shoppingapp_xml.userstorage.UserStorage


@Suppress("DEPRECATION")
class SplashFragment : androidx.fragment.app.Fragment() {

    var navController: NavController? = null
    var binding: FragmentSplashBinding? = null
    lateinit var userStorage: UserStorage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding?.apply {
            getStartedBtn.setOnClickListener {
                navController?.navigate(R.id.action_splashFragment_to_loginFragment)
            }

        }


    }
}