package com.itsch.commons

import java.lang.ref.WeakReference

/**
 * Created by Isma-Developer on 1/26/2018.
 */
open class BasePresenter<V : BaseView> constructor() : Presenter<V> {

    private var weakReference: WeakReference<V>? = null

    override fun attachView(view: V) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
        }
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }

    val view: V?
        get() = weakReference?.get()


    private val isViewAttached: Boolean
        get() = weakReference != null && weakReference!!.get() != null

}