package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private var _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoeList :LiveData<MutableList<Shoe>>
        get() = _shoesList


    init {
    _shoesList.value = List_of_Shoes()
    }

    //function to return list of shoes
  private   fun List_of_Shoes(): MutableList<Shoe>? {

        val sample_one = Shoe("Sample 1",10.0,"Sample Company 1","Sample Shoes 1")
        val sample_two = Shoe("Sample 2",11.0,"Sample Company 2","Sample Shoes 2")
        val sample_three = Shoe("Sample 3",12.0,"Sample Company 3","Sample Shoes 3")
        val sample_four = Shoe("Sample 4",13.0,"Sample Company 4","Sample Shoes 4")

        var mutableList = mutableListOf<Shoe>()
        mutableList.add(sample_one)
        mutableList.add(sample_two)
        mutableList.add(sample_three)
        mutableList.add(sample_four)
        return mutableList

    }

    //function for adding new Shoe to List
    fun add_Shoe_to_List(newShoe : Shoe)
    {
   //     _shoes.value =newShoe
        _shoesList.value?.add(newShoe)
    }

}