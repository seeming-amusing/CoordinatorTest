package com.seemingamusing.android.playground.footer

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.seemingamusing.android.playground.R

class FooterBarBehavior : AppBarLayout.ScrollingViewBehavior {

  constructor()
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

  override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View) =
      isFooterBar(dependency).also { isFooterBar ->
        if (isFooterBar) adjustChildBottomMargin(child, dependency)
      } || super.layoutDependsOn(parent, child, dependency)

  private fun isFooterBar(dependency: View) = dependency.id == R.id.footer_bar

  private fun adjustChildBottomMargin(child: View, dependency: View) {
    val height = when (dependency.visibility) {
      View.VISIBLE -> dependency.height
      else -> 0
    }
    (child.layoutParams as CoordinatorLayout.LayoutParams).bottomMargin = height
    Log.d(javaClass.simpleName, "Height: $height")
  }

  override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View, dependency: View): Boolean {
    if (isFooterBar(dependency)) adjustChildBottomMargin(child, dependency)
    return super.onDependentViewChanged(parent, child, dependency)
  }
}