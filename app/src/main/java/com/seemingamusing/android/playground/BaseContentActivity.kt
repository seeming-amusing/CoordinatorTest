package com.seemingamusing.android.playground

import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.seemingamusing.android.playground.common.MockedDataAdapter
import kotlinx.android.synthetic.main.content_adapter.*

abstract class BaseContentActivity : AppCompatActivity() {

  protected fun initializeContentView(behavior: CoordinatorLayout.Behavior<*>? = null) {
    content_view.apply {
      behavior?.let { setBehavior(it) }
      layoutManager = LinearLayoutManager(context)
      adapter = MockedDataAdapter(context)
    }
  }
}