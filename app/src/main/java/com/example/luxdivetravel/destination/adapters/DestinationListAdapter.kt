package com.example.luxdivetravel.destination.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.luxdivetravel.databinding.FragmentDestinationListItemContentBinding
import com.example.luxdivetravel.main.Review
import kotlinx.android.synthetic.main.fragment_destination_list_item_content.view.*
import kotlinx.android.synthetic.main.fragment_main_content.view.*

class DestinationListAdapter(private val reviewList: ArrayList<Review>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onItemClick: ((View) -> Unit)? = null
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
            .load(reviewList[position].image)
            .into(holder.itemView.imageView)
//        holder.itemView.imageView.setImageResource(reviewList[position].image)
        holder.itemView.item_content.setOnClickListener {
            onItemClick!!.invoke(it)
        }
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

}