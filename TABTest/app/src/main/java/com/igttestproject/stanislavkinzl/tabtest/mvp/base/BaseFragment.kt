package com.igttestproject.stanislavkinzl.tabtest.mvp.base

import android.support.v4.app.Fragment
import com.igttestproject.stanislavkinzl.tabtest.R

open class BaseFragment : Fragment() {

    fun startFragment(fragment: Fragment) {
        activity!!.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                .addToBackStack(null)
                .commit()
    }

    open fun injectComponents() {}
}
