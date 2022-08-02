package com.example.luxdivetravel.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.domain.models.Product
import com.example.luxdivetravel.databinding.FragmentDestinationListItemContentBinding
import kotlinx.android.synthetic.main.fragment_destination_list_item_content.view.*

class RecyclerViewAdapter(private val countryList: List<Product>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onItemClick: ((Product) -> Unit)? = null
    private var _binding: FragmentDestinationListItemContentBinding? = null
    private val binding get() = _binding!!

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        _binding = FragmentDestinationListItemContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(countryList[position].mainPicture)
            .into(holder.itemView.imageView)
        holder.itemView.item_content.setOnClickListener {
            onItemClick!!.invoke(countryList[position])
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

}