package com.example.luxdivetravel.homePage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentMainPageBinding
import com.example.luxdivetravel.databinding.RecyclerviewContentBinding

class MainRecyclerAdapter() :
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>(), View.OnClickListener {
    private lateinit var binding: RecyclerviewContentBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MainRecyclerAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        binding = RecyclerviewContentBinding.inflate(inflater)
        binding.whyUs.setOnClickListener (this)
        binding.notification.setOnClickListener(this)
        binding.search.setOnClickListener(this)
        binding.email.setOnClickListener(this)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.whyUs.id ->   Log.d(
                "why_us",
                "WHY US HAS BEEN CLICKED"
            )
            binding.notification.id ->Log.d(
                "why_us",
                "NOTIFICATION HAS BEEN CLICKED"
            )
            binding.email.id ->Log.d(
                "why_us",
                "EMAIL HAS BEEN CLICKED"
            )
            binding.search.id ->Log.d(
                "why_us",
                "SEARCH HAS BEEN CLICKED"
            )
        }
    }
}