package com.quang.appchat.activity

import android.os.Bundle
import com.quang.appchat.R
import com.quang.appchat.base.BaseActivity
import kotlinx.android.synthetic.main.register_act.*

class RegisterAct : BaseActivity() {
    override fun initView() {
        tv_goTologin.setOnClickListener {
            finish()
        }
    }

    override fun setup() = Setup(TAG, R.layout.register_act)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    companion object {
        private val TAG: String = RegisterAct::class.java.name
    }

}