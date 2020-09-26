package com.example.onehundred.ui.fragments.user

import androidx.lifecycle.ViewModel
import com.example.onehundred.data.entity.item.ITEM
import com.example.onehundred.data.entity.user.Profile
import com.example.onehundred.data.network.ApiService
import com.example.onehundred.data.network.ApiServiceFactory
import io.reactivex.Observable

class UserViewModel : ViewModel() {

    fun profile(Token:String): Observable<Profile> {
        return service.profile_show("Bearer "+Token)
    }

    private val service: ApiService by lazy {
        ApiServiceFactory.getInstance()
    }
}