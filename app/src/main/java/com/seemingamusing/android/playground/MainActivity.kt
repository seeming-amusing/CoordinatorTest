package com.seemingamusing.android.playground

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.seemingamusing.android.playground.bottomsheet.BottomSheetActivity
import com.seemingamusing.android.playground.footer.FooterActivity
import com.seemingamusing.android.playground.topbar.TopBarActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    samples_listing.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = ActivitiesAdapter(context)
    }
  }
}

private class ActivitiesAdapter(context: Context) : RecyclerView.Adapter<ActivityViewHolder>() {

  private val activities = arrayOf(Sample(TopBarActivity::class, R.string.sample_top_bar),
                                   Sample(FooterActivity::class, R.string.sample_footer),
                                   Sample(BottomSheetActivity::class, R.string.sample_bottom_sheet))
  private val inflater: LayoutInflater = LayoutInflater.from(context)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      inflater.inflate(R.layout.content_item, parent, false).let { ActivityViewHolder(it) }

  override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
    val (activityClass, nameId) = activities[position]
    holder.activity.apply {
      setText(nameId)
      setOnClickListener { context.startActivity(Intent(context, activityClass.java)) }
    }
  }

  override fun getItemCount() = activities.size
}

private class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val activity = itemView.findViewById(R.id.text_content) as TextView
}

private data class Sample(val activityClass: KClass<out Activity>, @StringRes val nameId: Int)
