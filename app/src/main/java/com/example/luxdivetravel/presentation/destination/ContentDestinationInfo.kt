package com.example.luxdivetravel.presentation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.luxdivetravel.databinding.FragmentContentDestinationInfoBinding
import com.example.luxdivetravel.presentation.adapters.ContentAdapter


class ContentDestinationInfo : Fragment() {
    private var _binding : FragmentContentDestinationInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentDestinationInfoBinding.inflate(inflater, container, false)
        binding.fragmentRecyclerView.adapter = ContentAdapter()
        binding.fragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}