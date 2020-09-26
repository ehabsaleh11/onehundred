package com.example.onehundred.ui.activity.main

import android.util.DisplayMetrics
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModel
import com.example.onehundred.data.entity.user.USER
import com.example.onehundred.data.network.ApiService
import com.example.onehundred.data.network.ApiServiceFactory
import io.reactivex.Observable


class MainViewModel() : ViewModel() {
    // TODO: Implement the ViewModel
    fun categories(): Observable<USER> {
        return service.login(" ","")
    }

    private val service: ApiService by lazy {
        ApiServiceFactory.getInstance()
    }


}