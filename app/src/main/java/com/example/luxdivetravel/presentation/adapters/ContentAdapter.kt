package com.example.luxdivetravel.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.luxdivetravel.databinding.DestinationInfoContentBinding
import com.example.luxdivetravel.presentation.adapters.ContentAdapter.ViewHolder

class ContentAdapter() :
    RecyclerView.Adapter<ViewHolder>() {
    private var _binding: DestinationInfoContentBinding? = null
    private val binding get() = _binding!!

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        _binding = DestinationInfoContentBinding.inflate(inflater)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 1
    }
}