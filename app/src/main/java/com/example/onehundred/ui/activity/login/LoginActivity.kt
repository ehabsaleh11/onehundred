package com.example.onehundred.ui.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.onehundred.R
import com.example.onehundred.data.local.UserSharedPreference
import com.example.onehundred.databinding.ActivityLoginBinding
import com.example.onehundred.ui.activity.main.MainActivity
import com.example.onehundred.ui.activity.main.MainViewModel
import com.example.onehundred.util.Intent
import com.example.onehundred.util.showToast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
      private lateinit var viewModel: LoginViewModel
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        // Create progressBar dynamically...



        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.model = viewModel
    }

    fun login(view: View) {
         if (user_name.text!!.isEmpty() || user_password.text!!.isEmpty()) {
            view.context.showToast("Fill all data")
        } else {
             progrss.visibility = View.VISIBLE

             viewModel.login(user_name.text.toString(), user_password.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ completed ->
                     progrss.visibility = View.GONE

                     if (completed.success==true){
                        view.context.showToast("done")
                        UserSharedPreference(baseContext).addUserDetail(completed.data.authorization)
                        baseContext.Intent(MainActivity())
                    }

                }, { throwable ->
                    view.context.showToast("fail")
                     progrss.visibility = View.GONE

                })
        }
    }
}