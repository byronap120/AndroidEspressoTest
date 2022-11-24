package com.byronajin.androidtesting.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterUserViewModel : ViewModel() {

    private val _invalidUserData = MutableLiveData<Boolean>()
    val invalidUserData: LiveData<Boolean> = _invalidUserData

    private val _isUserRegister = MutableLiveData<Boolean>()
    val isUserRegister: LiveData<Boolean> = _isUserRegister

    fun registerUser(user: String, email: String) {
        if (user.isEmpty() || email.isEmpty()) {
            _invalidUserData.value = true
        } else {
            callBackendToRegisterUser(user, email)
        }
    }

    private fun callBackendToRegisterUser(user: String, email: String) {
        _isUserRegister.value = true
    }
}