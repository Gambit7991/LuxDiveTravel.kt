package com.example.luxdivetravel

import android.util.Log
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    init {
        Log.e("ViewModel", "VM created")
    }

    override fun onCleared() {
        Log.e("ViewModel", "VM cleared")
        super.onCleared()
    }
}