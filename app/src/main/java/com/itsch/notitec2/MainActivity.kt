package com.itsch.notitec2

import android.support.v4.app.Fragment
import com.itsch.commons.BaseActivity
import com.itsch.notitec2.inicio.InicioFragment
import com.itsch.notitec2.login.LoginFragment
import com.itsch.notitec2.servicios.ServiciosFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity() {
    override fun layoutResId() = R.layout.activity_main
    val ID_DEFAULT_FRAGMENT = R.id.inicio
    val fragments: HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.inicio, InicioFragment()),
            Pair(R.id.servicios, ServiciosFragment()),
            Pair(R.id.login, LoginFragment())
    )

    override fun initView() {
        super.initView()
        setSupportActionBar(toolbar)
        navigationMenu.selectedItemId = ID_DEFAULT_FRAGMENT
        initViewFragment()
        navigationMenu
                .setOnNavigationItemSelectedListener { item ->
                    val fragment: Fragment? = fragments[item.itemId]
                    replaceFragment(fragment)
                    true
                }
    }

    private fun replaceFragment(fragment: Fragment?) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
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

    private fun defaultFragment(): Fragment? {
        return fragments[ID_DEFAULT_FRAGMENT]
    }
}
