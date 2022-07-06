package com.example.luxdivetravel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.luxdivetravel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_main_content.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(tool_bar)
//        binding.btnGetDestinationList.setOnClickListener {
//            val navHostFragment =
//            val navController = navHostFragment.navController
//            navController.navigate(R.id.action_testMainFragment_to_destinationList)
//        }

    }
}