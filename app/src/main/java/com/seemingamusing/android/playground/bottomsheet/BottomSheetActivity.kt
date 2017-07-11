package com.seemingamusing.android.playground.bottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.seemingamusing.android.playground.BaseContentActivity
import com.seemingamusing.android.playground.R
import com.seemingamusing.android.playground.common.MockedDataAdapter
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.content_adapter.*
import kotlinx.android.synthetic.main.content_simple.*

class BottomSheetActivity : BaseContentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bottom_sheet)
    initializeContentView()
    initializeBottomSheet()
  }

  private fun initializeBottomSheet() {
    val behavior = initializeBottomSheetBehavior()
    sample_title.setBackgroundResource(R.color.bottomSheetBackground)
    sample_title.setOnClickListener { behavior.state = BottomSheetBehavior.STATE_EXPANDED }
  }

  private fun initializeBottomSheetBehavior() = BottomSheetBehavior.from(design_bottom_sheet).also {
    it.peekHeight = resources.getDimensionPixelSize(R.dimen.bottom_sheet_peek_height)
    it.state = BottomSheetBehavior.STATE_COLLAPSED
  }
}