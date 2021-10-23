package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentNewShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel


class NewShoeFragment : Fragment() {

    private lateinit var binding :FragmentNewShoeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     //activity view model as per project requirement
        val   viewModel: ShoeViewModel by activityViewModels()

//implementing two way data Binding as explained here
        //https://knowledge.udacity.com/questions/692432

        //initializing
        binding.viewModelShoe = viewModel
        binding.newShoe = Shoe("",0.0,"","")

        binding.lifecycleOwner = this


        viewModel.isShoeAdded.observe(viewLifecycleOwner, Observer { addingShoeComplete->
            if(addingShoeComplete) {
                Navigation.findNavController(view)
                    .navigate(NewShoeFragmentDirections.actionNewShoeFragmentToShoeListingFragment())
            viewModel.addingComplete()
            }
        })


        binding.cancelButton.setOnClickListener {
            Navigation.findNavController(view).navigate(NewShoeFragmentDirections.actionNewShoeFragmentToShoeListingFragment())

        }

    }



}