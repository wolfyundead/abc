package com.example.mvvm.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodels.LoginViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.setViewModel(LoginViewModel())
        activityMainBinding.executePendingBindings()
    }

    companion object {
        @BindingAdapter("toastMessage")
        fun runMe(view: View, message: String?) {
            if (message != null) Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT)
                .show()
        }
    }
}