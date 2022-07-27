package com.example.luxdivetravel.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.domain.models.ContactUsForm
import com.example.domain.domain.models.User

class ViewModel : ViewModel() {

    private val wayLiveData = MutableLiveData<User>()
    val wayLive: LiveData<User> = wayLiveData

    init {
        val user = User()
        wayLiveData.value = user
        Log.e("ViewModel", "VM created")
    }

    override fun onCleared() {
        Log.e("ViewModel", "VM cleared")
        super.onCleared()
    }

    fun pushChoice(choice: String) {
        wayLiveData.value!!.way.add(choice)
        Log.e("VM", choice)
    }

    fun popChoiceUseCase() {
        with(wayLiveData.value!!.way) {
            if (isNotEmpty()) {
                removeLast()
            }
        }
    }

    fun saveContactUsFormUseCase(form: ContactUsForm) {
        with(wayLiveData.value!!.contactUsForm) {
            name = form.name
            email = form.email
            phoneNumber = form.phoneNumber
            message = form.message
        }
    }

    fun getContactUsFormUseCase(): ContactUsForm {
        return wayLiveData.value!!.contactUsForm
    }
}