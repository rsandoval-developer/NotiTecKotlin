package com.itsch.commons

/**
 * Created by Isma-Developer on 1/26/2018.
 */
interface BaseView {

    fun onError(error: String)
    fun showLoading()
    fun hideLoading()

}