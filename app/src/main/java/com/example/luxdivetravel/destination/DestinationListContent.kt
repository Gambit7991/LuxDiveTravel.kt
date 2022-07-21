package com.example.luxdivetravel.destination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentDestinationListContentBinding
import com.example.luxdivetravel.destination.adapters.DestinationListAdapter
import com.example.luxdivetravel.main.Review


class DestinationListContent : Fragment() {
    private var _binding: FragmentDestinationListContentBinding? = null
    private val binding get() = _binding!!
    private var navController : NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDestinationListContentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        //TODO : Get pictures from the dataBase
        val sliderItems = ArrayList<Review>()
        sliderItems.add(Review("https://static8.depositphotos.com/1016676/814/i/450/depositphotos_8149454-stock-photo-giza.jpg"))
        sliderItems.add(Review("https://assets.gq.ru/photos/5d9f8505ae00fb00090c50d0/16:9/w_1280,c_limit/dc0036eba261fd2f54fa5babf8d3d5c4d1a51e18.jpeg"))
        sliderItems.add(Review("data:image/jpeg;base64,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"))
        sliderItems.add(Review("https://www.aifsabroad.com/images/country-page/aifsabroad-share-image-theGalapagosIslands.jpg"))
        sliderItems.add(Review("data:image/jpeg;base64,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"))
        //TODO : Get pictures from dataBase
        val destinationListAdapter = DestinationListAdapter(sliderItems)
        destinationListAdapter.onItemClick = {
            navController!!.navigate(R.id.action_destinationList_to_destinationInfo)
        }
        binding.destinationListRecycler.layoutManager = LinearLayoutManager(this.context)
        binding.destinationListRecycler.adapter = destinationListAdapter
    }
}