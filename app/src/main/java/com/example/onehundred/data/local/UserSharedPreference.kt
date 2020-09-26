package com.example.onehundred.data.local

import android.content.Context
import android.content.SharedPreferences

class UserSharedPreference(val context: Context) {
    var editor: SharedPreferences.Editor? = null
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    companion object {
        val SHARED_NAME: String = "user"
        val USER_TOCKEN = "USER_TOCKEN"
    }

    fun addUserDetail(
        api_token: String?
    ) {
        editor = sharedPreferences.edit()
        editor!!.putString(USER_TOCKEN, api_token)

        editor!!.commit()
    }

    fun getUserDetails(): HashMap<String, String>? {
        val users = HashMap<String, String>()
        users[USER_TOCKEN] = sharedPreferences.getString(USER_TOCKEN, null)!!

        return users
    }

}