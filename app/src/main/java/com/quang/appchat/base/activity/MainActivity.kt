package com.quang.appchat.base.activity

import android.content.Intent
import android.os.Bundle
import com.quang.appchat.R
import com.quang.appchat.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun setup() = Setup(TAG,R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tv_goRegister.setOnClickListener {
            val i = Intent(this, RegisterAct::class.java)
            startActivity(i)
        }
    }

    companion object {
        val TAG: String = MainActivity::class.java.name
    }

}
