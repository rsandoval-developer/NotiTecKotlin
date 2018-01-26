package com.itsch.notitec2

import android.os.Bundle
import android.support.v4.app.Fragment
import com.itsch.commons.BaseActivity
import com.itsch.notitec2.inicio.InicioFragment
import com.itsch.notitec2.login.LoginFragment
import com.itsch.notitec2.servicios.ServiciosFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity() {
    val ID_DEFAULT_FRAGMENT = R.id.inicio

    val fragments: HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.inicio, InicioFragment())
    )

    override fun getLayoutResId() = R.layout.activity_main


    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setSupportActionBar(toolbar)
        initViewFragment()
        navigationMenu.selectedItemId = R.id.inicio
        navigationMenu.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment? = fragments[item.itemId]

            if (fragment != null)
                replaceFragment(R.id.fragmentContainer, fragment)

            true
        }

    }

    private fun initViewFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (currentFragment == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, defaultFragment())
                    .commit()
        }
    }

    private fun replaceFragment(container: Int, fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(container, fragment)
                .commit()
    }

    private fun defaultFragment() = fragments[ID_DEFAULT_FRAGMENT]


}

