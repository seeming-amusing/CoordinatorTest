package com.seemingamusing.android.playground.footer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.seemingamusing.android.playground.R
import com.seemingamusing.android.playground.common.MockedDataAdapter
import kotlinx.android.synthetic.main.activity_footer.*
import kotlinx.android.synthetic.main.content_adapter.*

class FooterActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_footer)
    setTitle(R.string.sample_footer)
    setSupportActionBar(toolbar)
    content_view.apply {
      setBehavior(FooterBarBehavior())
      layoutManager = LinearLayoutManager(context)
      adapter = MockedDataAdapter(context)
    }
    footer_bar.setOnClickListener { footer_bar.visibility = View.GONE }
  }

  override fun setSupportActionBar(toolbar: Toolbar?) {
    toolbar?.setNavigationIcon(R.drawable.ic_arrow_back)
    toolbar?.setNavigationOnClickListener { finish() }
    super.setSupportActionBar(toolbar)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_toggleable_element, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId
    if (id == R.id.action_show) {
      toggleFooter(item)
      return true
    }
    return super.onOptionsItemSelected(item)
  }

  private fun toggleFooter(item: MenuItem) {
    when (footer_bar.visibility) {
      View.VISIBLE -> {
        footer_bar.visibility = View.GONE
        item.setTitle(R.string.action_show)
      }
      else -> {
        footer_bar.visibility = View.VISIBLE
        item.setTitle(R.string.action_hide)
      }
    }
  }
}