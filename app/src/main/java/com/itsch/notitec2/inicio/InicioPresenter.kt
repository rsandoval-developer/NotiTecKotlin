package com.itsch.notitec2.inicio

import com.itsch.commons.BasePresenter
import com.itsch.commons.BaseView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Isma-Developer on 1/26/2018.
 */
class InicioPresenter : BasePresenter<InicioPresenter.View>() {

    val service by lazy {
        InicioApiService.create()
    }

    var disposable: Disposable? = null

    fun getPost() {
        disposable = service.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response.status) {
                        view?.hideLoading()
                        view?.onSendBanners(response.banners)
                        view?.onSendPosts(response.posts)
                    }
                })
    }

    interface View : BaseView {
        fun onSendBanners(banners: List<Banner>)
        fun onSendPosts(posts: List<Post>)
    }
}