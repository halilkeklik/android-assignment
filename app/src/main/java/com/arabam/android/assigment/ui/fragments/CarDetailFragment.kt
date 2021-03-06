package com.arabam.android.assigment.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapters.CarDetailImageAdapter
import com.arabam.android.assigment.adapters.CarDetailPropertiesAdapter
import com.arabam.android.assigment.models.FetchState
import com.arabam.android.assigment.ui.activites.MainActivity
import com.arabam.android.assigment.ui.viewModels.CarDetailViewModel

class CarDetailFragment : Fragment(R.layout.fragment_car_detail),
    CarDetailImageAdapter.OnItemClickListener {

    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: CarDetailImageAdapter
    private lateinit var propertiesView: RecyclerView
    private lateinit var propertiesAdapter: CarDetailPropertiesAdapter
    private lateinit var carDetailViewModel: CarDetailViewModel
    private lateinit var detailTitleTextView: TextView
    private lateinit var detailPriceTextView: TextView
    private lateinit var detailModelTextView: TextView
    private lateinit var detailDateTextView: TextView
    private lateinit var detailLocationTextView: TextView
    private lateinit var progressView: ProgressBar
    private lateinit var errorTextView: TextView
    private lateinit var detailLayout: LinearLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = view.findViewById(R.id.viewPager2)
        detailDateTextView = view.findViewById(R.id.detail_date)
        detailPriceTextView = view.findViewById(R.id.detail_price)
        detailModelTextView = view.findViewById(R.id.detail_model)
        detailTitleTextView = view.findViewById(R.id.detail_title)
        propertiesView = view.findViewById(R.id.detail_properties)
        progressView = view.findViewById(R.id.progress_bar)
        errorTextView = view.findViewById(R.id.txt_error)
        detailLayout = view.findViewById(R.id.detail_layout)
        detailLocationTextView = view.findViewById(R.id.detail_location)
        carDetailViewModel = ViewModelProvider(this).get(CarDetailViewModel::class.java)
        initViews()
        observeViewModel()

    }

    private fun initViews() {
        viewPagerAdapter = CarDetailImageAdapter(this)
        viewPager2.adapter = viewPagerAdapter

        propertiesAdapter = CarDetailPropertiesAdapter()
        propertiesView.adapter = propertiesAdapter
        propertiesView.layoutManager = LinearLayoutManager(context)
    }

    private fun observeViewModel() = with(carDetailViewModel) {
        getCarDetail().observe(viewLifecycleOwner, {
            detailTitleTextView.text = it.title ?: getString(R.string.defult_value)
            detailModelTextView.text = it.modelName ?: getString(R.string.defult_value)
            detailDateTextView.text =
                it.dateFormatted ?: it.date
            detailPriceTextView.text =
                it.priceFormatted ?: getString(R.string.price_formatted, it.price)
            detailLocationTextView.text =
                if (it.location.cityName != null || it.location.townName != null)
                    getString(R.string.location,
                        it.location.cityName,
                        it.location.townName)
                else
                    getString(R.string.location_default)
            viewPagerAdapter.submitList(it.photos.mapNotNull {
                it
            })
            // properties herhangi bir elemanı yoksa listede gözükmemesi için filter kullanıldı
            propertiesAdapter.submitList(it.properties.mapNotNull {
                it
            }.filter {
                it.name != null && it.value != null
            })
        })
        getState().observe(viewLifecycleOwner, { state ->
            progressView.visibility =
                if (state == FetchState.LOADING) View.VISIBLE else View.GONE
            errorTextView.visibility =
                if (state == FetchState.ERROR) View.VISIBLE else View.GONE
            detailLayout.visibility =
                if (state == FetchState.DONE) View.VISIBLE else View.GONE
        })
    }

    override fun onItemClicked(url: String) {
        (activity as MainActivity).showFullScreenFragment(url)
    }

}