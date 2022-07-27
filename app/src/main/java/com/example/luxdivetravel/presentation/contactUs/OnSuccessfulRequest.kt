package com.example.luxdivetravel.presentation.contactUs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentOnSuccessfulRequestBinding


class OnSuccessfulRequest : Fragment() {
    private var _binding: FragmentOnSuccessfulRequestBinding? = null
    private val binding get() = _binding!!
    private var navController : NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnSuccessfulRequestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
        binding.entirePicture.setOnClickListener{
            findNavController().navigate(R.id.action_onSuccessfulRequest_to_mainPage)
            parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}