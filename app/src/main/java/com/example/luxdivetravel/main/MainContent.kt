package com.example.luxdivetravel.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.luxdivetravel.databinding.FragmentMainContentBinding
import com.example.luxdivetravel.main.adapters.MainContentAdapter
import com.flaviofaria.kenburnsview.RandomTransitionGenerator

class MainContent : Fragment() {
    private var _binding: FragmentMainContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainContentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentRecyclerView.adapter = MainContentAdapter()
        binding.fragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        setImgAnimation()
    }

    private fun setImgAnimation() {
        binding.kenBurnView.setTransitionGenerator(
            RandomTransitionGenerator(
                5000,
                AccelerateDecelerateInterpolator()
            )
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

    }
}