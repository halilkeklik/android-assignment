package com.arabam.android.assigment.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapters.CarItemAdapter
import com.arabam.android.assigment.models.FetchState
import com.arabam.android.assigment.ui.activites.MainActivity
import com.arabam.android.assigment.ui.viewModels.CarListViewModel

class CarListFragment : Fragment(R.layout.fragment_car_list), CarItemAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var carItemAdapter: CarItemAdapter
    private lateinit var carListViewModel: CarListViewModel
    private lateinit var progressView: ProgressBar
    private lateinit var errorTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview)
        progressView = view.findViewById(R.id.progress_bar)
        errorTextView = view.findViewById(R.id.txt_error)
        carListViewModel = ViewModelProvider(this).get(CarListViewModel::class.java)
        initViews()
        observeViewModel()
    }

    private fun initViews() {
        errorTextView.setOnClickListener {
            carListViewModel.retry()
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            carItemAdapter = CarItemAdapter(this@CarListFragment)
            adapter = carItemAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (recyclerView.canScrollVertically(1).not()) {
                        carListViewModel.retry()
                    }
                }
            })
        }
    }

    private fun observeViewModel() = with(carListViewModel) {
        getCarList().observe(viewLifecycleOwner, {
            carItemAdapter.submitList(it)
        })
        getState().observe(viewLifecycleOwner, { state ->
            progressView.visibility =
                if (state == FetchState.LOADING) View.VISIBLE else View.GONE
            errorTextView.visibility =
                if (state == FetchState.ERROR) View.VISIBLE else View.GONE
            recyclerView.visibility =
                if (state != FetchState.ERROR) View.VISIBLE else View.GONE
        })
    }

    override fun onItemClicked(id: Int) {
        (activity as MainActivity).showCarDetailFragment(id)
    }


}