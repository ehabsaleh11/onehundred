package com.example.onehundred.ui.fragments.home

import androidx.lifecycle.ViewModel
import com.example.onehundred.data.entity.item.ITEM
import com.example.onehundred.data.entity.user.USER
import com.example.onehundred.data.network.ApiService
import com.example.onehundred.data.network.ApiServiceFactory
import io.reactivex.Observable

class HomeViewModel : ViewModel() {
    fun sold_items(Token:String): Observable<ITEM> {
        return service.sold_item_count("Bearer "+Token)
    }

    fun product_count(Token:String): Observable<ITEM> {
        return service.product_count("Bearer "+Token)
    }

    private val service: ApiService by lazy {
        ApiServiceFactory.getInstance()
    }

}