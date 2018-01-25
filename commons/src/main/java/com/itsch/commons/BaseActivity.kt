package com.itsch.commons

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Isma-Developer on 1/25/2018.
 */

abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId())
        initView()
    }
    open fun initView() {

    }
}
