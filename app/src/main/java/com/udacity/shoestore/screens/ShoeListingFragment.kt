package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import org.w3c.dom.Text

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


        //    binding.LinearLayoutList.addView()
        val viewModel =ViewModelProvider(this).get(ShoeViewModel::class.java)


        for(shoe in viewModel.shoeList.value!!)
        {
            val viewGroup = linearViewForShoe(shoe)
            binding.LinearLayoutList.addView(viewGroup)
        }


    }

    private fun linearViewForShoe(shoe: Shoe): LinearLayout {
        val linearLayout  = LinearLayout(context)


        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )

        layoutParams.setMargins(16,16,16,16)


        linearLayout.layoutParams =layoutParams
        linearLayout.orientation = LinearLayout.HORIZONTAL

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


}