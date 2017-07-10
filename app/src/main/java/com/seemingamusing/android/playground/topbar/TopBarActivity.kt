package com.seemingamusing.android.playground.topbar

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import com.seemingamusing.android.playground.R
import com.seemingamusing.android.playground.common.MockedDataAdapter
import kotlinx.android.synthetic.main.activity_top_bar.*
import kotlinx.android.synthetic.main.content_adapter.*

class TopBarActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_top_bar)
    initializeToolbar()
    initializeTopBar()
    initializeContentView()
  }

  private fun initializeToolbar() {
    toolbar.apply {
      setTitle(R.string.sample_top_bar)
      setNavigationIcon(R.drawable.ic_arrow_back)
      setNavigationOnClickListener { finish() }
    }
  }

  private fun initializeTopBar() {
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    val statusBarHeight = when {
      resourceId > 0 -> resources.getDimensionPixelSize(resourceId)
      else -> 0
    }
    (top_bar.layoutParams as ViewGroup.MarginLayoutParams).topMargin += statusBarHeight
  }

  private fun initializeContentView() {
    content_view.apply {
      setBehavior(AppBarLayout.ScrollingViewBehavior())
      layoutManager = LinearLayoutManager(context)
      adapter = MockedDataAdapter(context)
    }
  }
}