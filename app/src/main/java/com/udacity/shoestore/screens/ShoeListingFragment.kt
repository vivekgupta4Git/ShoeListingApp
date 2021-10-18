package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoelistingBinding
    private lateinit var viewModel: ShoeViewModel
            override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                //inflating layout
        binding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_shoelisting,
        container,false)

                viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)



        return binding.root
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }




}