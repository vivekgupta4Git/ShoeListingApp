package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.databinding.ItemLayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import org.w3c.dom.Text

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
//        use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
     val   viewModel: ShoeViewModel by activityViewModels()


        viewModel.shoeList.observe(viewLifecycleOwner, { list_of_shoes->
            for (shoe in list_of_shoes)
            {
                itemBinding = ItemLayoutBinding.inflate(layoutInflater)
                itemBinding.shoeData = shoe
            }
        })

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