package com.example.luxdivetravel.mainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.luxdivetravel.MainActivity.Companion.viewPagerSettings
import com.example.luxdivetravel.PageTransformerEnum
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentMainPageBinding
import com.example.luxdivetravel.mainPage.adapters.SliderAdapter
import kotlinx.android.synthetic.main.fragment_main_page.*


class MainPage : Fragment(), View.OnClickListener {
    private var _binding: FragmentMainPageBinding? = null
    private var navController: NavController? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainPageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        onClickListenerSetter()
        //TODO : Get pictures from the dataBase
        val sliderItems: MutableList<Review> = ArrayList()
        sliderItems.add(Review(R.drawable.first_slide))
        sliderItems.add(Review(R.drawable.second_slide))
        sliderItems.add(Review(R.drawable.third_slide))
        sliderItems.add(Review(R.drawable.fourth_slide))
        sliderItems.add(Review(R.drawable.fifth_slide))
        //TODO : Get pictures from dataBase
        binding.mainPageViewPager.adapter = SliderAdapter(sliderItems, viewPager)
        viewPagerSettings(
            viewPager = binding.mainPageViewPager,
            slideShowType = PageTransformerEnum.FOREGROUND.name
        )
    }

    private fun onClickListenerSetter() {
        binding.btnGetDestinationList.setOnClickListener(this)
        binding.email.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_get_destination_list -> navController!!.navigate(R.id.action_mainPage_to_destinationInfo)
            email -> navController!!.navigate(R.id.action_mainPage_to_onSuccessfulRequest)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}