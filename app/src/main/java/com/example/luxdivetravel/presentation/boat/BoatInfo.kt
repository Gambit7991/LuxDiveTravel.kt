package com.example.luxdivetravel.presentation.boat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.luxdivetravel.PageTransformerEnum
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentBoatInfoBinding
import com.example.luxdivetravel.presentation.MainActivity
import com.example.luxdivetravel.presentation.adapters.SliderAdapter
import com.example.luxdivetravel.presentation.main.Review
import com.example.luxdivetravel.viewmodel.MainViewModel


class BoatInfo : Fragment(), View.OnClickListener {
    private var _binding: FragmentBoatInfoBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null
    private val sharedMainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoatInfoBinding.inflate(inflater)
        onClickSetter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    sharedMainViewModel.popChoiceUseCase()
                    super.setEnabled(false)
                    findNavController().popBackStack()
                }
            })
        //TODO : Get pictures from the dataBase
        val sliderItems: MutableList<Review> = ArrayList()
        sliderItems.add(Review("https://img.redbull.com/images/c_limit,w_1500,h_1000,f_auto,q_auto/redbullcom/2018/09/17/5595aa2e-863a-4243-ad43-87437f688e78/scuba-diving"))
        sliderItems.add(Review("https://swoop-antarctica.imgix.net/OW_3_JOHN-NEUSCHWANDER_RTD_CAMPING.jpeg?auto=format,enhance,compress&fit=crop&crop=entropy,faces,focalpoint&w=1200&h=0&q=30"))
        sliderItems.add(Review("https://travel.mqcdn.com/mapquest/travel/wp-content/uploads/2020/06/GettyImages-636982952-e1592703310661.jpg"))
        sliderItems.add(Review("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS00gAICSCjQ0GaB7YxZ80gW5NTikS86LXRQpa4xQAKpfp0fhc78f0lAbfCF6TeFumhcWg&usqp=CAU"))
        sliderItems.add(Review("https://kohtaodivers.com/templates/yootheme/cache/1kohtaodiving-openwaterdiver-tryscube-thailand-scuba-27311be0.jpeg"))
        //TODO : Get pictures from dataBase
        binding.viewPager.adapter =
            SliderAdapter(sliderItems, binding.viewPager)
        MainActivity.viewPagerSettings(
            viewPager = binding.viewPager,
            slideShowType = PageTransformerEnum.CUBE_OUT.name,
            isAuto = true
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v!!) {
            binding.btnHome -> navController!!.navigate(R.id.action_boatInfo_to_mainPage)
//            binding.btnInstagram -> TODO ->
//            binding.btnFacebook ->  TODO ->
            binding.contactUs -> navController!!.navigate(R.id.action_boatInfo_to_onSuccessfulRequest)
            binding.btnContactUs -> navController!!.navigate(R.id.action_boatInfo_to_onSuccessfulRequest)
        }
    }

    private fun onClickSetter() {
        binding.btnHome.setOnClickListener(this)
        binding.btnInstagram.setOnClickListener(this)
        binding.btnFacebook.setOnClickListener(this)
        binding.btnContactUs.setOnClickListener(this)
        binding.contactUs.setOnClickListener(this)
    }

}