package com.seemingamusing.android.playground.footer;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.seemingamusing.android.playground.R;

public class FooterBarBehavior extends AppBarLayout.ScrollingViewBehavior {

  public FooterBarBehavior() {
  }

  public FooterBarBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
    boolean isFooterBar = isFooterBar(dependency);
    if (isFooterBar) {
      adjustChildBottomMargin(child, dependency);
    }
    return isFooterBar || super.layoutDependsOn(parent, child, dependency);
  }

  private void adjustChildBottomMargin(View child, View dependency) {
    CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
    int height = 0;
    if (dependency.getVisibility() == View.VISIBLE) {
      height = dependency.getHeight();
    }
    lp.bottomMargin = height;
    Log.d(getClass().getSimpleName(), "Height: " + height);
  }

  private boolean isFooterBar(View dependency) {
    return dependency.getId() == R.id.footer_bar;
  }

  @Override
  public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
    if (isFooterBar(dependency)) {
      adjustChildBottomMargin(child, dependency);
    }
    return super.onDependentViewChanged(parent, child, dependency);
  }
}