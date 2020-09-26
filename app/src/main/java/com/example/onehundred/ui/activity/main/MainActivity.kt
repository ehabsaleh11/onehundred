package com.example.onehundred.ui.activity.main

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.onehundred.R
import com.example.onehundred.ui.fragments.home.HomeFragment
import com.example.onehundred.ui.fragments.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,HomeFragment.newInstance()).commit()
        home.setOnClickListener {
            trancaction(HomeFragment.newInstance())

            user.setColorFilter(ContextCompat.getColor(baseContext, R.color.gray), android.graphics.PorterDuff.Mode.MULTIPLY);
            search.setColorFilter(ContextCompat.getColor(baseContext, R.color.gray), android.graphics.PorterDuff.Mode.MULTIPLY);



        }

        user.setOnClickListener {
            trancaction(UserFragment.newInstance())
            search.setColorFilter(ContextCompat.getColor(baseContext, R.color.gray), android.graphics.PorterDuff.Mode.MULTIPLY);
            user.setColorFilter(ContextCompat.getColor(baseContext, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);

        }

        search.setOnClickListener {
            trancaction(UserFragment.newInstance())
            user.setColorFilter(ContextCompat.getColor(baseContext, R.color.gray), android.graphics.PorterDuff.Mode.MULTIPLY);
            search.setColorFilter(ContextCompat.getColor(baseContext, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);

        }

    }

    fun trancaction(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).addToBackStack(fragment.tag).commit()
    }
}