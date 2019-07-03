package com.quang.appchat.base.activity

import android.os.Bundle
import com.quang.appchat.R
import com.quang.appchat.base.BaseActivity
import kotlinx.android.synthetic.main.register_act.*

class RegisterAct : BaseActivity(){
    override fun setup() = Setup(TAG,R.layout.register_act)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tv_goTologin.setOnClickListener{
            finish()
        }
    }

    companion object {
        private val TAG : String = RegisterAct::class.java.name
    }
    
}