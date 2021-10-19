package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.databinding.ItemLayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoelistingBinding
    private lateinit var itemBinding : ItemLayoutBinding

            override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
         savedInstanceState: Bundle?
    ): View? {
                //inflating layout
        binding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_shoelisting,
        container,false)

                setHasOptionsMenu(true)

       return binding.root
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(ShoeListingFragmentDirections.actionShoeListingFragmentToNewShoeFragment())
                )



        val viewModel : ShoeViewModel by activityViewModels()


        viewModel.shoeList.observe(requireActivity(), Observer {

            it.forEach{shoe->
                addShoe(shoe)
            }


        })

    }


    //displaying shoe list in onCreate
    fun addShoe(s : Shoe){
        itemBinding = ItemLayoutBinding.inflate(layoutInflater,binding.LinearLayoutList,false)

        itemBinding.shoeData = s
        binding.LinearLayoutList.addView(itemBinding.root)

    }


   override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}