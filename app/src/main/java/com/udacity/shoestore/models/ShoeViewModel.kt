package com.udacity.shoestore.models

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel : ViewModel() {


    init {
        Timber.i("Shoe ViewModel Created")
    }

    //function to return list of shoes
    fun shoeList(){

    }


}