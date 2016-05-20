package com.seemingamusing.android.playground.topbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.seemingamusing.android.playground.R;
import com.seemingamusing.android.playground.common.MockedDataAdapter;

public class TopBarActivity extends AppCompatActivity {

  @Bind(R.id.content_view) RecyclerView mContentView;
  @Bind(R.id.top_bar) View mTopBar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_bar);
    ButterKnife.bind(this);
    initializeContentView();
  }

  private void initializeContentView() {
    mContentView.setLayoutManager(new LinearLayoutManager(this));
    mContentView.setAdapter(new MockedDataAdapter(this));
  }
}