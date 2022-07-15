package com.example.luxdivetravel.mainPage.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.luxdivetravel.R
import com.example.luxdivetravel.mainPage.Review
import com.makeramen.roundedimageview.RoundedImageView

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
        fun image(review: Review) {
            return imageView.setImageResource(review.image)
        }
        private val imageView: RoundedImageView = view.findViewById(R.id.image_holder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_to_slide,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.image(sliderItems[position])
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