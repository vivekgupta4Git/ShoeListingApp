package com.example.shoestoreproject.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Shoe(var name: String,
                         var size: Double,
                         var company: String,
                         var description: String,
                         val images: List<String> = mutableListOf()) : Parcelable {

}
