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
import androidx.lifecycle.ViewModelProvider
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

        //onClick listener for save Button
        binding.saveButton.setOnClickListener {


            var name = binding.nameEditTxt.text.toString()

            //checking for null or empty string
            if(name.isNullOrEmpty())
            {
                name =""
            }

            var company = binding.companyEditTxt.text.toString()

            if(company.isNullOrEmpty())
            {
                company = ""
            }

            //if unable to convert to double set it to 0.0 using elvis operator
            val size = binding.sizeEditTxt.text.toString().toDoubleOrNull() ?: 0.0

            //checking for Null or Empty
            var description = binding.descriptionEditTxt.text.toString()
            if(description.isNullOrEmpty())
            {
                description = ""
            }

            //calling add shoe to list function of viewModel
            viewModel.add_Shoe_to_List(Shoe(name,size,company,description))
        }
    }



}