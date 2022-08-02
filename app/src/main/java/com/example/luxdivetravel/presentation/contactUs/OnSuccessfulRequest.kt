package com.example.luxdivetravel.presentation.contactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentOnSuccessfulRequestBinding
import com.example.luxdivetravel.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class OnSuccessfulRequest : Fragment() {
    private var _binding: FragmentOnSuccessfulRequestBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null
    private val sharedViewModel by sharedViewModel<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnSuccessfulRequestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        childFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.top_in,
            R.anim.top_pop_in,
        ).commit()
        sharedViewModel.isDisabled.observe(viewLifecycleOwner) {
            if (it.equals(false)) {
                binding.entirePicture.setOnClickListener {
                    findNavController().navigate(R.id.action_onSuccessfulRequest_to_mainPage)
                    parentFragmentManager.popBackStack(
                        null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                }
                sharedViewModel.setDisabled(boolean = true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}