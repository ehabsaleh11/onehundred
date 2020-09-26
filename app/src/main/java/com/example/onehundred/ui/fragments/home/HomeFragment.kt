package com.example.onehundred.ui.fragments.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onehundred.R
import com.example.onehundred.data.local.UserSharedPreference
import com.example.onehundred.ui.activity.main.MainActivity
import com.example.onehundred.util.Intent
import com.example.onehundred.util.showToast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() =
            HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.product_count(UserSharedPreference(context!!).getUserDetails()!!.get(UserSharedPreference.USER_TOCKEN)!! )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ completed ->
                if (completed.status=="success"){
                     prodct_count.setText(completed.data.toString())
                }else{
                    context!!.showToast("fail")
                }

            }, { throwable ->
                context!!.showToast("fail")

            })

        viewModel.sold_items(UserSharedPreference(context!!).getUserDetails()!!.get(UserSharedPreference.USER_TOCKEN)!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ completed ->
                if (completed.status=="success"){
                     sold_count.setText(completed.data.toString())
                }else{
                    context!!.showToast("fail")
                }

            }, { throwable ->
                context!!.showToast("fail")

            })

    }

}