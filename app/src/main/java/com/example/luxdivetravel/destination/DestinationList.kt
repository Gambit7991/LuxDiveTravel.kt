package com.example.luxdivetravel.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.luxdivetravel.MainActivity.Companion.viewPagerSettings
import com.example.luxdivetravel.PageTransformerEnum
import com.example.luxdivetravel.R
import com.example.luxdivetravel.SliderAdapter
import com.example.luxdivetravel.databinding.FragmentDestinationListBinding
import com.example.luxdivetravel.destination.adapters.DestinationListAdapter
import com.example.luxdivetravel.main.Review


class DestinationList : Fragment() {
    private var _binding: FragmentDestinationListBinding? = null
    private val binding get() = _binding!!

    companion object {
    }

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

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}