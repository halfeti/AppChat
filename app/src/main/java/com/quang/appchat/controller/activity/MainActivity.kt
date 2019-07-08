package com.quang.appchat.activity

import android.content.Intent
import android.os.Bundle
import com.quang.appchat.R
import com.quang.appchat.base.BaseActivity
import com.quang.appchat.controller.activity.ListGroupAct
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun initView() {
        tv_goRegister.setOnClickListener {
            var i = Intent(this, RegisterAct::class.java)
            startActivity(i)
        }
        btn_login.setOnClickListener{
            var i = Intent(this, ListGroupAct::class.java)
            startActivity(i)
        }
    }

    override fun setup() = Setup(
        TAG,
        R.layout.activity_main
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    companion object {
        val TAG: String = MainActivity::class.java.name
    }

}
