package com.example.luxdivetravel.homePage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentMainPageBinding
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.fragment_main_page.*


class MainPage : Fragment() , View.OnClickListener {
    private lateinit var binding: FragmentMainPageBinding
    private var navController : NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.btnGetDestinationList.setOnClickListener(this)
        binding.bottomNavigation.setOnItemSelectedListener { set(it) }

    }

    override fun onResume() {
        super.onResume()

    }


    override fun onClick(v: View?) {
        when (v!!.id){
            btn_get_destination_list.id -> navController!!.navigate(R.id.action_mainPage_to_onSuccessfulRequest)
            R.id.contact_us_item -> navController!!.navigate(R.id.action_mainPage_to_onSuccessfulRequest)
        }
    }

    private fun set(v:MenuItem) : Boolean{
        when(v.itemId){
            R.id.contact_us_item -> navController!!.navigate(R.id.action_mainPage_to_onSuccessfulRequest)
        }
        return true
    }


}

