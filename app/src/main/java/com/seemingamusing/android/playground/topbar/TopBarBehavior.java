package com.seemingamusing.android.playground.topbar;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TopBarBehavior extends CoordinatorLayout.Behavior<View> {

  public TopBarBehavior() {
  }

  public TopBarBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
    return dependency instanceof NestedScrollingChild;
  }

  @Override
  public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
    CoordinatorLayout.LayoutParams params =
        (CoordinatorLayout.LayoutParams) dependency.getLayoutParams();
    params.topMargin = child.getHeight();
    return true;
  }

  @Override public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child,
      View directTargetChild, View target, int nestedScrollAxes) {
    return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
  }

  @Override
  public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target,
      int dx, int dy, int[] consumed) {
    CoordinatorLayout.LayoutParams childParams =
        (CoordinatorLayout.LayoutParams) child.getLayoutParams();
    CoordinatorLayout.LayoutParams targetParams =
        (CoordinatorLayout.LayoutParams) target.getLayoutParams();
    int maxHeight = child.getHeight();
    if (isScrollingUp(dy)) {
      log("Scrolling up");
      scrollUp(dx, maxHeight, childParams, targetParams);
    } else {
      log("Scrolling down");
      scrollDown(dx, maxHeight, childParams, targetParams);
    }
  }

  private void log(String message) {
    Log.d(getClass().getSimpleName(), message);
  }

  private boolean isScrollingUp(int dy) {
    return dy >= 0;
  }

  private void scrollUp(int dx, int maxHeight, CoordinatorLayout.LayoutParams childParams,
      CoordinatorLayout.LayoutParams targetParams) {
    childParams.topMargin -= dx;
    targetParams.topMargin -= dx;
    if (childParams.topMargin < -maxHeight) childParams.topMargin = -maxHeight;
    if (targetParams.topMargin < 0) targetParams.topMargin = 0;
  }

  private void scrollDown(int dx, int maxHeight, CoordinatorLayout.LayoutParams childParams,
      CoordinatorLayout.LayoutParams targetParams) {
    childParams.topMargin += dx;
    targetParams.topMargin += dx;
    if (childParams.topMargin > 0) childParams.topMargin = 0;
    if (targetParams.topMargin > maxHeight) targetParams.topMargin = maxHeight;
  }
}