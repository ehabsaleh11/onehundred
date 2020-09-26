package com.example.onehundred.ui.fragments.user

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.onehundred.R
import com.example.onehundred.data.local.UserSharedPreference
import com.example.onehundred.util.showToast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.image
import kotlinx.android.synthetic.main.user_fragment.*

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()
    }

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        progrss.visibility=View.VISIBLE
        viewModel.profile(
            UserSharedPreference(context!!).getUserDetails()!!.get(
                UserSharedPreference.USER_TOCKEN
            )!!
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ completed ->
                progrss.visibility=View.GONE

                Glide
                    .with(context!!)
                    .load(completed.data.avatar)
                    .centerCrop()
                    .placeholder(R.drawable.avatar_temp)
                    .into(image);
                user_name.text = completed.data.name

            }, { throwable ->
                context!!.showToast("fail")
                progrss.visibility=View.GONE

            })

    }

}