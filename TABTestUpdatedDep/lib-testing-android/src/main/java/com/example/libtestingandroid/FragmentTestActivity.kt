package com.example.libtestingandroid

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector

class FragmentTestActivity : AppCompatActivity(), HasSupportFragmentInjector {

    private lateinit var injector: AndroidInjector<Fragment>

    override fun supportFragmentInjector() = injector

    fun <T> startFragment(fragment: Fragment, injector: (T) -> Unit, withTag: String = "TAG") {
        this.injector = AndroidInjector {
            @Suppress("UNCHECKED_CAST")
            injector(it as T)
        }
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, fragment, withTag)
            .commit()
    }

}