package com.seemingamusing.android.playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.seemingamusing.android.playground.common.MockedDataAdapter;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.content_view) RecyclerView mContentView;
  @Bind(R.id.footer_bar) FrameLayout mFooterBar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
    initializeContentView();
  }

  private void initializeContentView() {
    mContentView.setLayoutManager(new LinearLayoutManager(this));
    mContentView.setAdapter(new MockedDataAdapter(this));
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_show) {
      mFooterBar.setVisibility(View.VISIBLE);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @OnClick(R.id.footer_bar) public void hideFooter() {
    mFooterBar.setVisibility(View.GONE);
  }
}