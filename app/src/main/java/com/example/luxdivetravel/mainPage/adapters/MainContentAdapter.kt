package com.example.luxdivetravel.mainPage.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.luxdivetravel.databinding.MainPageContentBinding
import com.example.luxdivetravel.mainPage.adapters.MainContentAdapter.ViewHolder

class MainContentAdapter() :
    RecyclerView.Adapter<ViewHolder>() {
    private var _binding: MainPageContentBinding? = null
    private val binding get() = _binding!!

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        _binding = MainPageContentBinding.inflate(inflater)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        _binding = null
    }

}