package com.seemingamusing.android.playground.topbar

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.view.ViewGroup
import com.seemingamusing.android.playground.BaseContentActivity
import com.seemingamusing.android.playground.R
import kotlinx.android.synthetic.main.activity_top_bar.*

class TopBarActivity : BaseContentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_top_bar)
    initializeTopBar()
    initializeContentView(AppBarLayout.ScrollingViewBehavior())
  }

  private fun initializeTopBar() {
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    val statusBarHeight = when {
      resourceId > 0 -> resources.getDimensionPixelSize(resourceId)
      else -> 0
    }
    (top_bar.layoutParams as ViewGroup.MarginLayoutParams).topMargin += statusBarHeight
  }
}