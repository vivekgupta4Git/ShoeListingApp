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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import org.w3c.dom.Text

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoelistingBinding
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

        for(shoe in viewModel.shoeList.value!!)
        {
            val viewGroup = linearViewForShoe(shoe)
            binding.LinearLayoutList.addView(viewGroup)
        }


    }



    private fun linearViewForShoe(shoe: Shoe): LinearLayout {
        //initializing variable of linearlayout
        val linearLayout  = LinearLayout(context)

        //creating parameters for layout
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        //16dp margin for linearlayout
        layoutParams.setMargins(16,16,16,16)

        //adding this params to linearlayout
        linearLayout.layoutParams =layoutParams

        /*
        1. A new item layout is created for each item
        2. New item layout is added to LinearLayout
        3. Layout is updated with items added on the detail screen

         */

        //setting orientation to horizontal to show a single shoe detail horizontally i.e column wise
        linearLayout.orientation = LinearLayout.HORIZONTAL

        //creating a textview , setting it params and setting its text value
        val shoeNameText = TextView(context)
        shoeNameText.layoutParams = layoutParams
        shoeNameText.text = shoe.name

        val shoeSizeText = TextView(context)
        shoeSizeText.layoutParams = layoutParams
        shoeSizeText.text = shoe.size.toString()

        val shoeCompanyText = TextView(context)
        shoeCompanyText.layoutParams = layoutParams
        shoeCompanyText.text = shoe.company

        val shoeDescriptionText = TextView(context)
        shoeDescriptionText.layoutParams = layoutParams
        shoeDescriptionText.text = shoe.description

        linearLayout.addView(shoeNameText)
        linearLayout.addView(shoeSizeText)
        linearLayout.addView(shoeCompanyText)
        linearLayout.addView(shoeDescriptionText)


        return linearLayout

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