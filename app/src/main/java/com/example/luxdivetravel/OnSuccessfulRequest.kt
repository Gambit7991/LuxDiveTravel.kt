package com.example.luxdivetravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class OnSuccessfulRequest : Fragment() {
    companion object {
        fun newInstance(): OnSuccessfulRequest {
            return OnSuccessfulRequest()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_successful_request, container, false)
    }


}