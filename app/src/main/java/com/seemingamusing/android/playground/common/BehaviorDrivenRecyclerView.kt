package com.seemingamusing.android.playground.common

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class BehaviorDrivenRecyclerView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
  : RecyclerView(context, attrs, defStyle) {

  fun setBehavior(behavior: CoordinatorLayout.Behavior<*>) {
    if (parent !is CoordinatorLayout) {
      throw IllegalStateException("Cannot attach a behavior to this RecyclerView; it must be nested within a CoordinatorLayout")
    }
    (layoutParams as CoordinatorLayout.LayoutParams).behavior = behavior
  }
}