package com.example.luxdivetravel

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.luxdivetravel.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var vm: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("ViewModel", "ActivityCreated")
        vm = ViewModelProvider(this)[ViewModel::class.java]
    }

    companion object {
        private fun fakeDrag(
            viewPager: ViewPager2,
            leftToRight: Boolean,
            duration: Long
        ) {
            val pxToDrag: Int = viewPager.width
            val animator = ValueAnimator.ofInt(0, pxToDrag)
            var previousValue = 0
            animator.addUpdateListener { valueAnimator ->
                val currentValue = valueAnimator.animatedValue as Int
                var currentPxToDrag: Float =
                    (currentValue - previousValue).toFloat()
                when {
                    leftToRight -> {
                        currentPxToDrag *= -1
                    }
                }
                viewPager.fakeDragBy(currentPxToDrag)
                previousValue = currentValue
            }
            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                    viewPager.beginFakeDrag()
                }

                override fun onAnimationEnd(animation: Animator?) {
                    viewPager.endFakeDrag()
                }

                override fun onAnimationCancel(animation: Animator?) { /* Ignored */
                }

                override fun onAnimationRepeat(animation: Animator?) { /* Ignored */
                }
            })
            animator.interpolator = AccelerateDecelerateInterpolator()
            animator.duration = duration
            animator.start()
        }

        fun viewPagerSettings(
            viewPager: ViewPager2,
            slideShowType: String,
            isAuto: Boolean
        ) {
            val sliderHandler = Handler(Looper.getMainLooper())
            viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            with(viewPager) {
                when (slideShowType) {
                    PageTransformerEnum.CUBE_OUT.name -> setPageTransformer { page, position ->
                        page.pivotX = (if (position < 0f) page.width else 0).toFloat()
                        page.pivotY = page.height * 0.5f
                        page.rotationY = 90f * position
                    }
                    PageTransformerEnum.FOREGROUND.name -> setPageTransformer { page, position ->
                        val width = page.width.toFloat()
                        val scale: Float = min(if (position > 0) 1f else abs(1f + position), 1f)
                        page.scaleX = scale
                        page.scaleY = scale
                        page.pivotX = (page.width * 0.5).toFloat()
                        page.pivotY = (page.height * 0.5).toFloat()
                        page.translationX =
                            if (position > 0) width * position else -width * position * 0.25f
                    }
                }
                if (isAuto) {
                    val sliderRunnable = Runnable { fakeDrag(viewPager, true, 5000) }
                    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                            sliderHandler.removeCallbacks(sliderRunnable)
                            sliderHandler.postDelayed(sliderRunnable, 4000)
                        }
                    })
                }
            }
        }
    }
}

