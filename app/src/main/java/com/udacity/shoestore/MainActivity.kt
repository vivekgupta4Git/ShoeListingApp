package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //planting a tree for debugging
        Timber.plant(Timber.DebugTree())

        //find a nav Controller
        val navController = this.findNavController(R.id.myNavHostFragment)

        //Configuration AppBar using navigation graph
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        //hooking up ActionBar using Nav Controller with appBarConfiguration
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)



    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()

    }
}
