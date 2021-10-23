package com.example.shoestoreproject.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //declaring binding variable
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflating layout using Databinding Util
        binding= DataBindingUtil.inflate(inflater,
            R.layout.fragment_login,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Login Button Onclick Listener
        //using safe args  for navigation.
        binding.loginButton.setOnClickListener {

            //finding nav controller and navigating
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        //Signup Button Onclick Listener
        binding.signupButton.setOnClickListener(
            //using kotlin extension
            Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        )

    }

}