package com.seemingamusing.android.playground.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class BehaviorDrivenRecyclerView extends RecyclerView {

  public BehaviorDrivenRecyclerView(Context context) {
    super(context);
  }

  public BehaviorDrivenRecyclerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public BehaviorDrivenRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public void setBehavior(CoordinatorLayout.Behavior behavior) {
    if (!(getParent() instanceof CoordinatorLayout)) {
      throw new IllegalStateException("Cannot attach a behavior to this RecyclerView; it must be "
          + "nested within a CoordinatorLayout");
    }
    ((CoordinatorLayout.LayoutParams) getLayoutParams()).setBehavior(behavior);
  }
}
