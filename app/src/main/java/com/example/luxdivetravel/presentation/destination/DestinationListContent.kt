package com.example.luxdivetravel.presentation.destination

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.domain.models.Boat
import com.example.domain.domain.models.Country
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentDestinationListContentBinding
import com.example.luxdivetravel.presentation.adapters.RecyclerViewAdapter
import com.example.luxdivetravel.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DestinationListContent : Fragment() {
    private var _binding: FragmentDestinationListContentBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null
    private val sharedMainViewModel by sharedViewModel<MainViewModel>()

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
        //TODO: get list from dataBase
        val destinationList: List<Country> = listOf(
            Country(
                "egypt",
                "etc_0",
                0,
                "https://th.bing.com/th/id/OIP.mZapq96DE83W0nMRGRsvHwHaHa?w=160&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7",
                ArrayList<String>(10),
                ArrayList<Boat>(10)
            ), Country(
                "maldives",
                "etc_1",
                1,
                "https://th.bing.com/th/id/OIP.Ik5UHX7JTrJ6ry6U_5gWZgHaE8?w=272&h=181&c=7&r=0&o=5&dpr=1.25&pid=1.7",
                ArrayList<String>(10),
                ArrayList<Boat>(10)
            ), Country(
                "galapagos islands",
                "etc_2",
                2,
                "https://th.bing.com/th/id/OIP.RhzIN0feSM7_ZpPwy-q9mgHaE8?w=253&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7",
                ArrayList<String>(10) ,
                ArrayList<Boat>(10)
            ), Country(
                "dubai",
                "etc_3",
                3,
                "https://th.bing.com/th/id/OIP.W4Fe6hnQamugdibMVkAahwHaEK?w=275&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7",
                ArrayList<String>(10),
                ArrayList<Boat>(10)
            ), Country(
                "greece",
                "etc_4",
                4,
                "https://th.bing.com/th/id/OIP.JVP9Dpgym30NDZe77H0EZQHaE7?w=273&h=182&c=7&r=0&o=5&dpr=1.25&pid=1.7",
                ArrayList<String>(10),
                ArrayList<Boat>(10)
            ),
            Country(
                "british virgin islands",
                "etc_5",
                5,
                "https://th.bing.com/th/id/OIP.ZxFRHUOOo7J2vbwtgLC_8QHaFj?w=206&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7",
                ArrayList<String>(10),
                ArrayList<Boat>(10)
            )
        )
        //TODO: get list from dataBase
        val recyclerViewAdapter = RecyclerViewAdapter(destinationList)
        recyclerViewAdapter.onItemClick = {
            navController!!.navigate(R.id.action_destinationList_to_destinationInfo)
            sharedMainViewModel.pushChoice(it.name)
            Log.e("VM", "In on Item Click")
        }
        binding.destinationListRecycler.layoutManager = LinearLayoutManager(this.context)
        binding.destinationListRecycler.adapter = recyclerViewAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}