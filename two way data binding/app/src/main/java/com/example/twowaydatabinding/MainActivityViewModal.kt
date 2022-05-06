package com.example.twowaydatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModal: ViewModel() {
    val username = MutableLiveData<String>()

    init {
        username.value = "Lakes"
    }
}