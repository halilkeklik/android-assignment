package com.arabam.android.assigment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arabam.android.assigment.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val carListFragment = CarListFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.carListFragment, carListFragment)
            commit()
        }
    }


}