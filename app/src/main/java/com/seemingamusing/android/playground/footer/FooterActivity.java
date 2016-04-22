package com.seemingamusing.android.playground.footer;

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
import com.seemingamusing.android.playground.R;
import com.seemingamusing.android.playground.common.MockedDataAdapter;

public class FooterActivity extends AppCompatActivity {

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.content_view) RecyclerView mContentView;
  @Bind(R.id.footer_bar) FrameLayout mFooterBar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_footer);
    ButterKnife.bind(this);
    setTitle(R.string.sample_footer);
    setSupportActionBar(mToolbar);
    initializeContentView();
  }

  @Override public void setSupportActionBar(Toolbar toolbar) {
    mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });
    super.setSupportActionBar(toolbar);
  }

  private void initializeContentView() {
    mContentView.setLayoutManager(new LinearLayoutManager(this));
    mContentView.setAdapter(new MockedDataAdapter(this));
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_footer, menu);
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