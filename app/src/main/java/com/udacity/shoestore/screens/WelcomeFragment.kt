package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    //declaring biding variable
    private lateinit var binding : FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            //inflating view using DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //after the view Created, set up onclick listener on Go Button

        binding.letsGoButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
    }

}