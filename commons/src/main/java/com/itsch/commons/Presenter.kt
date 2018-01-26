package com.itsch.commons

/**
 * Created by Isma-Developer on 1/26/2018.
 */
interface Presenter<V : BaseView> {

    fun attachView(view: V)
    fun detachView()
}