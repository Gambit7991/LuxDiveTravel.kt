package com.example.luxdivetravel.presentation.boat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.domain.domain.models.Boat
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentBoatListBinding
import com.example.luxdivetravel.presentation.main.Review


class BoatList : Fragment(), View.OnClickListener{
    private var _binding : FragmentBoatListBinding? = null
    private var navController : NavController? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoatListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        //TODO : Get pictures from the dataBase
       //TODO : Get pictures from the dataBase
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
        when (v!!) {
            binding.btnHome -> navController!!.navigate(R.id.action_boatList_to_mainPage)
//            binding.btnInstagram ->
//            binding.btnFacebook ->
            binding.btnContactUs -> navController!!.navigate(R.id.action_boatList_to_onSuccessfulRequest)
        }
    }
}