package com.quang.appchat.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.dwiariyanto.androidkotlinsimpledemo.core.fragment.BaseFragment
import com.quang.appchat.view.dialog.LoadingDialog

/**
 * Created by Dwi_Ari on 10/14/17.
 */

abstract class BaseActivity : AppCompatActivity() {
    val loadingDialog: LoadingDialog by lazy { LoadingDialog() }

    protected val setup: Setup by lazy { setup() }

    val currentFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(setup.containerId)

    abstract fun setup(): Setup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (setup.layoutId != 0)
            setContentView(setup.layoutId)
    }

    override fun onBackPressed() {
        if (currentFragment != null && (currentFragment as BaseFragment).onBackPressed()) return
        super.onBackPressed()

        if (currentFragment != null) {
            if (currentFragment is BaseFragment)
                (currentFragment!! as BaseFragment).restoreFromBackPress()
        } else {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        currentFragment?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun replaceFragment(fragment: BaseFragment,
                        backStack: Boolean = true,
                        layoutId: Int = setup.containerId) {
        if (isFragmentAlreadyAttach(fragment.setup.tag)) return

        val transaction = supportFragmentManager.beginTransaction()
                .replace(layoutId, fragment)

        if (backStack)
            transaction.addToBackStack(fragment.setup.tag)

        transaction.commitAllowingStateLoss()
    }

    fun addFragment(fragment: BaseFragment,
                    backStack: Boolean = true,
                    layoutId: Int = setup.containerId) {
        if (isFragmentAlreadyAttach(fragment.setup.tag)) return

        val transaction = supportFragmentManager.beginTransaction()
                .add(layoutId, fragment, fragment.setup.tag)

        if (backStack)
            transaction.addToBackStack(fragment.setup.tag)

        transaction.commitAllowingStateLoss()
    }

    private fun isFragmentAlreadyAttach(tag: String): Boolean {
        return supportFragmentManager.fragments.any { it.tag == tag }
    }

    open fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    protected fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    class Setup(val tag: String,
                val layoutId: Int = 0,
                val containerId: Int = android.R.id.content)

    protected companion object {
        const val FEATURE_OPEN = "feature_open"
        const val FEATURE_NAME = "feature_name"
    }
}