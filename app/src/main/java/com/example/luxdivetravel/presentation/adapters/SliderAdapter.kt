package com.example.luxdivetravel.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.luxdivetravel.R
import com.example.luxdivetravel.presentation.main.Review
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.review_item.view.*

class SliderAdapter internal constructor(
    sliderItems: MutableList<Review>,
    viewPager: ViewPager2
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    private val sliderItems: List<Review>
    private val viewPager: ViewPager2

    init {
        this.sliderItems = sliderItems
        this.viewPager = viewPager
    }


    class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.review_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        Glide.with(getActivity(holder.itemView.context)!!.applicationContext)
            .load(sliderItems[position].image)
            .into(holder.itemView.image_holder)
        if (position >= sliderItems.size - 2) {
            viewPager.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }

    private val runnable = Runnable {
        sliderItems.addAll(sliderItems)
        notifyDataSetChanged()
    }
}