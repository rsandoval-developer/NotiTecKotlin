package com.itsch.notitec2.inicio

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.itsch.commons.BaseFragment
import com.itsch.commons.extensions.loadImage
import com.itsch.commons.extensions.snack
import com.itsch.notitec2.R
import kotlinx.android.synthetic.main.fragment_inicio.*
import kotlinx.android.synthetic.main.loading_layout.*
import kotlinx.android.synthetic.main.slider_item.view.*

/**
 * Created by Isma-Developer on 1/25/2018.
 */
class InicioFragment : BaseFragment(), InicioPresenter.View {


    override fun getLayoutResId(): Int {
        return R.layout.fragment_inicio
    }

    var presenter: InicioPresenter? = null

    override fun initView() {
        super.initView()
        presenter = InicioPresenter()
        presenter?.attachView(this)
        recyclerPost.layoutManager =
                LinearLayoutManager(activity,
                        LinearLayout.VERTICAL, false)
    }


    override fun onResume() {
        super.onResume()
        presenter?.getPost()
    }


    override fun onError(error: String) {
        view?.snack(error, Snackbar.LENGTH_LONG)
    }


    override fun showLoading() {
        loadingBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingBar.visibility = View.GONE
    }

    override fun onSendBanners(banners: List<Banner>) {
        if (banners != null) {
            for (item: Banner in banners) {
                var urlBanner: String = item.imageUrl!!
                val slide = object : BaseSliderView(activity) {
                    override fun getView(): View {
                        val view = layoutInflater.inflate(R.layout.slider_item, null)
                        view.imageSlider.loadImage(urlBanner)
                        return view
                    }
                }
                slider.addSlider(slide)
            }
            slider.setPresetTransformer(SliderLayout.Transformer.Tablet)
            slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
            slider.setCustomAnimation(DescriptionAnimation())
            slider.setDuration(4000)
            slider.setCustomIndicator(custom_indicator)

        }
    }

    override fun onSendPosts(posts: List<Post>) {
        recyclerPost.visibility = View.VISIBLE
        recyclerPost.adapter = PostAdapter(posts)
    }

}