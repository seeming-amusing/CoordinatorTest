package com.seemingamusing.android.playground.stack

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.view.View
import com.seemingamusing.android.playground.BaseContentActivity
import com.seemingamusing.android.playground.R
import kotlinx.android.synthetic.main.activity_stacking.*

class StackingActivity : BaseContentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_stacking)
    initializeContentView()
    bottom_content.apply {
      setBackgroundResource(R.color.colorAccent)
      (layoutParams as CoordinatorLayout.LayoutParams).behavior = StackingBehavior<View>().apply {
        targetId = R.id.content_view
      }
    }
  }
}