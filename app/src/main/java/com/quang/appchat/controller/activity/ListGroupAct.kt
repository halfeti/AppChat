package com.quang.appchat.controller.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.quang.appchat.R
import com.quang.appchat.base.BaseActivity
import com.quang.appchat.controller.adapter.AdapterListGroup
import kotlinx.android.synthetic.main.act_list_group_chat.*

class ListGroupAct : BaseActivity() {
    val text: ArrayList<String> = ArrayList()

    override fun initView() {
        addAnimals()
        rv_list_group.layoutManager = LinearLayoutManager(this)
        rv_list_group.adapter = AdapterListGroup(text,this)
    }

    private fun addAnimals() {
        for (i in 1..2) {
            text.add("dog")
            text.add("cat")
            text.add("owl")
            text.add("cheetah")
            text.add("raccoon")
        }
    }

    override fun setup() = Setup(TAG, R.layout.act_list_group_chat)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    companion object {
        val TAG: String = ListGroupAct::class.java.name
    }
}