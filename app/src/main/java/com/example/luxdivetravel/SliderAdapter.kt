package com.example.luxdivetravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.luxdivetravel.destination.adapters.DestinationListAdapter
import com.example.luxdivetravel.main.Review
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.fragment_destination_list_item_content.view.*
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
//        private val imageView: RoundedImageView = view.findViewById(R.id.image_holder)
//        fun image(review: Review, holder: SliderViewHolder) {
//            Glide.with(holder.itemView)
//                .load(review)
//                .into(imageView)
////            return imageView.setImageResource(review.image)
//        }


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
        Glide.with(holder.itemView)
            .load(sliderItems[position].image)
            .into(holder.itemView.image_holder)
//        holder.image(sliderItems[position], holder)
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