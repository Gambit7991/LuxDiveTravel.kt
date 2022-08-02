package com.example.luxdivetravel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.domain.models.ContactUsForm
import com.example.domain.domain.models.User
import com.example.domain.domain.useCases.GetDestinationListUseCase
import com.example.domain.domain.useCases.SendContactFormUseCase

class MainViewModel(
    getDestinationListUseCase: GetDestinationListUseCase,
    sendContactFormUseCase: SendContactFormUseCase
) : ViewModel() {

    private val wayLiveData = MutableLiveData<User>()
    val wayLive: LiveData<User> = wayLiveData
    private var isDisabledLive = MutableLiveData<Boolean>()
    val isDisabled : LiveData<Boolean> = isDisabledLive

    init {
        isDisabledLive.value = true
        val user = User()
        wayLiveData.value = user
    }

    fun setDisabled(boolean: Boolean){
        isDisabledLive.value = boolean
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun pushChoice(choice: String) {
        wayLiveData.value!!.way.add(choice)
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

}