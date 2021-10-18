package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment  : Fragment() {

        //declaring binding variable
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflating layout using DatabindingUtil
        binding= DataBindingUtil.inflate(inflater,
      R.layout.fragment_login,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Login Button Onclick Listener
        binding.loginButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        //Signup Button Onclick Listener
        binding.signupButton.setOnClickListener {
         //   Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
    }

}