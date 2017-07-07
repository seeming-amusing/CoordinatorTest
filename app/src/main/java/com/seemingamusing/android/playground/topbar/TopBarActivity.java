package com.seemingamusing.android.playground.topbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.seemingamusing.android.playground.R;
import com.seemingamusing.android.playground.common.BehaviorDrivenRecyclerView;
import com.seemingamusing.android.playground.common.MockedDataAdapter;

public class TopBarActivity extends AppCompatActivity {

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.top_bar) View mTopBar;
  @Bind(R.id.content_view) BehaviorDrivenRecyclerView mContentView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_bar);
    ButterKnife.bind(this);
    initializeToolbar();
    initializeTopBar();
    initializeContentView();
  }

  private void initializeToolbar() {
    mToolbar.setTitle(R.string.sample_top_bar);
    mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });
  }

  private void initializeTopBar() {
    int statusBarHeight = 0;
    int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      statusBarHeight = getResources().getDimensionPixelSize(resourceId);
    }
    ((ViewGroup.MarginLayoutParams) mTopBar.getLayoutParams()).topMargin += statusBarHeight;
  }

  private void initializeContentView() {
    mContentView.setBehavior(new AppBarLayout.ScrollingViewBehavior());
    mContentView.setLayoutManager(new LinearLayoutManager(this));
    mContentView.setAdapter(new MockedDataAdapter(this));
  }
}