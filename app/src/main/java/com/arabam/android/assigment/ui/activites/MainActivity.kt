package com.arabam.android.assigment.ui.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arabam.android.assigment.R
import com.arabam.android.assigment.ui.fragments.CarDetailFragment
import com.arabam.android.assigment.ui.fragments.CarListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        if (savedInstanceState == null) {
            showCarListFragment()
        }
    }

    private fun showCarListFragment() {
        val carListFragment = CarListFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.carListFragment, carListFragment)
            commit()
        }
    }

    fun showCarDetailFragment(id: Int) {
        val carDetailFragment = CarDetailFragment()
        val bundle = Bundle()
        bundle.putInt("id", id)
        carDetailFragment.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.carListFragment, carDetailFragment).addToBackStack(null)
            commit()
        }
    }
}
