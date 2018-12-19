package com.agiletech.ajaxapp.authorization.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.agiletech.ajaxapp.MainActivity
import com.agiletech.ajaxapp.R
import com.agiletech.ajaxapp.base.activity.BaseActivity
import com.agiletech.ajaxapp.databinding.ActivityWelcomeBinding

class WelcomeActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {

            }
            R.id.btn_sign_up -> {

            }
            R.id.btn_facebook -> {

            }
            R.id.btn_login_instagram -> {

            }
            R.id.btn_skip -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    lateinit var mBinding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        mBinding.onClick = this
    }
}