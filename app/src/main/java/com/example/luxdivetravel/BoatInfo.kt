package com.example.luxdivetravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 * Use the [BoatInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class BoatInfo : Fragment() {

    companion object {
        fun newInstance(): BoatInfo {
            return BoatInfo()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_boat_info, container, false)
    }


}