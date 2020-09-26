package com.example.onehundred.ui.activity.login

import android.util.DisplayMetrics
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onehundred.data.entity.user.USER
import com.example.onehundred.data.network.ApiService
import com.example.onehundred.data.network.ApiServiceFactory
import com.example.onehundred.util.showToast
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class LoginViewModel() : ViewModel() {
    // TODO: Implement the ViewModel
    var userName = ObservableField<String>()
    var userPassword = ObservableField<String>()

    fun login(userName: String, password: String): Observable<USER> {
        return service.login(userName, password)
    }

    private val service: ApiService by lazy {
        ApiServiceFactory.getInstance()
    }



}