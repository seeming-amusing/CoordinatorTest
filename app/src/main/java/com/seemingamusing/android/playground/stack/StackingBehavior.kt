package com.seemingamusing.android.playground.stack

import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.view.View


class StackingBehavior<V : View> : CoordinatorLayout.Behavior<V>() {

  var targetId: Int = 0

  override fun onLayoutChild(parent: CoordinatorLayout, child: V, layoutDirection: Int): Boolean {
    parent.onLayoutChild(child, layoutDirection)
    ViewCompat.offsetTopAndBottom(child, parent.height)
    return true
  }

  override fun onStartNestedScroll(parent: CoordinatorLayout?, child: V,
                                   directTargetChild: View, target: View, nestedScrollAxes: Int)
      = target.id == targetId

  override fun onNestedPreScroll(parent: CoordinatorLayout, child: V, target: View,
                                 dx: Int, dy: Int, consumed: IntArray) {
    if (child.top < parent.bottom) {
      val difference = child.top - parent.bottom
      val offset = -maxOf(dy, difference)
      if (offset > 0) {
        child.offsetBy(offset)
        target.offsetBy(offset)
      }
    }
  }

  private fun View.offsetBy(offset: Int) = ViewCompat.offsetTopAndBottom(this, offset)

  override fun onNestedScroll(parent: CoordinatorLayout, child: V, target: View,
                              dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int,
                              dyUnconsumed: Int) {
    if (dyUnconsumed > 0) {
      val difference = child.bottom - parent.bottom
      val offset = -minOf(dyUnconsumed, difference)
      child.offsetBy(offset)
      target.offsetBy(offset)
    }
  }
}