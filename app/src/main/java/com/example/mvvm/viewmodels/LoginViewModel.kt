package com.example.mvvm.viewmodels


import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.mvvm.model.User


class LoginViewModel : BaseObservable() {
    private val user: User
    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    @Bindable
    var toastMessage: String? = null
        private set

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @get:Bindable
    var userEmail: String?
        get() = user.email
        set(email) {
            user.email = email!!
            notifyPropertyChanged(BR.userEmail)
        }

    @get:Bindable
    var userPassword: String?
        get() = user.password
        set(password) {
            user.password = password!!
            notifyPropertyChanged(BR.userPassword)
        }

    fun onLoginClicked() {
        if (isInputDataValid) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    val isInputDataValid: Boolean
        get() = !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(
            userEmail
        ).matches() && userPassword!!.length > 5

    init {
        user = User("", "")
    }
}