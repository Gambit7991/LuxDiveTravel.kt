package com.example.luxdivetravel.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.luxdivetravel.MainActivity.Companion.viewPagerSettings
import com.example.luxdivetravel.PageTransformerEnum
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentMainPageBinding
import com.example.luxdivetravel.SliderAdapter
import kotlinx.android.synthetic.main.fragment_main_page.*


class MainPage : Fragment(), View.OnClickListener {
    private var _binding: FragmentMainPageBinding? = null
    private var navController: NavController? = null
    private val binding get() = _binding!!

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
        onClickSetter()
        //TODO : Get pictures from the dataBase
        val sliderItems: MutableList<Review> = ArrayList()
        sliderItems.add(Review("https://img.redbull.com/images/c_limit,w_1500,h_1000,f_auto,q_auto/redbullcom/2018/09/17/5595aa2e-863a-4243-ad43-87437f688e78/scuba-diving"))
        sliderItems.add(Review("https://swoop-antarctica.imgix.net/OW_3_JOHN-NEUSCHWANDER_RTD_CAMPING.jpeg?auto=format,enhance,compress&fit=crop&crop=entropy,faces,focalpoint&w=1200&h=0&q=30"))
        sliderItems.add(Review("https://travel.mqcdn.com/mapquest/travel/wp-content/uploads/2020/06/GettyImages-636982952-e1592703310661.jpg"))
        sliderItems.add(Review("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS00gAICSCjQ0GaB7YxZ80gW5NTikS86LXRQpa4xQAKpfp0fhc78f0lAbfCF6TeFumhcWg&usqp=CAU"))
        sliderItems.add(Review("https://kohtaodivers.com/templates/yootheme/cache/1kohtaodiving-openwaterdiver-tryscube-thailand-scuba-27311be0.jpeg"))
        //TODO : Get pictures from dataBase
        binding.mainPageViewPager.adapter = SliderAdapter(sliderItems, binding.mainPageViewPager)
        viewPagerSettings(
            viewPager = binding.mainPageViewPager,
            slideShowType = PageTransformerEnum.FOREGROUND.name,
            isAuto = true
        )
    }

    private fun onClickSetter() {
        binding.btnGetDestinationList.setOnClickListener(this)
        binding.email.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_get_destination_list -> navController!!.navigate(R.id.action_mainPage_to_destinationList)
            email -> navController!!.navigate(R.id.action_mainPage_to_onSuccessfulRequest)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}