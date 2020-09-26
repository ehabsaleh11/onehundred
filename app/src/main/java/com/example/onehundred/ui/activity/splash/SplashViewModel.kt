package com.example.onehundred.ui.activity.splash

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.onehundred.ui.activity.login.LoginActivity
import com.example.onehundred.util.Intent


class SplashViewModel() : ViewModel() {

    fun splashClick(view: View) {
        view.context.Intent(LoginActivity())
    }
}