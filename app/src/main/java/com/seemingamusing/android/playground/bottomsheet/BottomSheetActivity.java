package com.seemingamusing.android.playground.bottomsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.seemingamusing.android.playground.R;
import com.seemingamusing.android.playground.common.MockedDataAdapter;

public class BottomSheetActivity extends AppCompatActivity {

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.content_view) RecyclerView mContentView;
  @Bind(R.id.design_bottom_sheet) View mBottomSheet;
  @Bind(R.id.sample_title) TextView mBottomSheetButton;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bottom_sheet);
    ButterKnife.bind(this);
    setUpToolbar();
    initializeContentView();
    initializeBottomSheet();
  }

  private void setUpToolbar() {
    mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });
  }

  private void initializeContentView() {
    mContentView.setLayoutManager(new LinearLayoutManager(this));
    mContentView.setAdapter(new MockedDataAdapter(this));
  }

  private void initializeBottomSheet() {
    final BottomSheetBehavior bottomSheetBehavior = initializeBottomSheetBehavior();
    mBottomSheetButton.setBackgroundResource(R.color.bottomSheetBackground);
    mBottomSheetButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
      }
    });
  }

  private BottomSheetBehavior initializeBottomSheetBehavior() {
    final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
    int peekHeight = getResources().getDimensionPixelSize(R.dimen.bottom_sheet_peek_height);
    bottomSheetBehavior.setPeekHeight(peekHeight);
    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
      @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {
        handleBottomSheetStateChanged(newState);
      }

      @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {

      }
    });
    return bottomSheetBehavior;
  }

  private void handleBottomSheetStateChanged(int newState) {
    switch (newState) {
      case BottomSheetBehavior.STATE_EXPANDED:
        mBottomSheetButton.setVisibility(View.GONE);
        break;
      case BottomSheetBehavior.STATE_COLLAPSED:
        mBottomSheetButton.setVisibility(View.VISIBLE);
        break;
      default:
        // does nothing
    }
  }
}