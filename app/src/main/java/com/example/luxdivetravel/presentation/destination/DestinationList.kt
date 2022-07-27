package com.example.luxdivetravel.presentation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentDestinationListBinding


class DestinationList : Fragment(), View.OnClickListener {
    private var _binding: FragmentDestinationListBinding? = null
    private val binding get() = _binding!!
    private var navController : NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDestinationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.btnHome.setOnClickListener(this)
        binding.btnInstagram.setOnClickListener(this)
        binding.btnFacebook.setOnClickListener(this)
        binding.btnContactUs.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v!!){
            binding.btnHome -> navController!!.navigate(R.id.action_destinationList_to_mainPage)
//            binding.btnInstagram ->
//            binding.btnFacebook ->
            binding.btnContactUs -> navController!!.navigate(R.id.action_destinationList_to_onSuccessfulRequest)
        }
    }
}