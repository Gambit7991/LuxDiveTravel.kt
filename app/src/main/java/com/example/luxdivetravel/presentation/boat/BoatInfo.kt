package com.example.luxdivetravel.presentation.boat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.luxdivetravel.R
import com.example.luxdivetravel.viewmodel.ViewModel
import com.example.luxdivetravel.databinding.FragmentBoatInfoBinding


class BoatInfo : Fragment(), View.OnClickListener {
    private var _binding : FragmentBoatInfoBinding? = null
    private val binding get() = _binding!!
    private var navController : NavController? = null
    private val sharedViewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoatInfoBinding.inflate(inflater)
        binding.btnHome.setOnClickListener(this)
        binding.btnInstagram.setOnClickListener(this)
        binding.btnFacebook.setOnClickListener(this)
        binding.btnContactUs.setOnClickListener(this)
        binding.contactUs.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Log.e("VM" ,"In Boat Info")
                    sharedViewModel.popChoiceUseCase()
                    super.setEnabled(false)
                    findNavController().popBackStack()
                }
            })
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

}