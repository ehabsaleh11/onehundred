package com.example.onehundred.ui.activity.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.onehundred.R
import com.example.onehundred.databinding.ActivitySplashBinding
import com.example.onehundred.ui.activity.login.LoginViewModel

class Splash : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var model: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        model = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        binding.splashModel = model
    }
}