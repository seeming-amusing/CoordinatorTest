package com.seemingamusing.android.playground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.seemingamusing.android.playground.bottomsheet.BottomSheetActivity
import com.seemingamusing.android.playground.footer.FooterActivity
import com.seemingamusing.android.playground.model.SampleActivity
import com.seemingamusing.android.playground.topbar.TopBarActivity
import kotlinx.android.synthetic.main.activity_main.*

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

private class ActivitiesAdapter constructor(context: Context)
  : RecyclerView.Adapter<ActivityViewHolder>() {

  private val activities = arrayOf(SampleActivity(TopBarActivity::class.java, "Top Bar Sample"),
                                   SampleActivity(FooterActivity::class.java, "Footer Sample"),
                                   SampleActivity(BottomSheetActivity::class.java, "Bottom Sheet Sample"))
  private val inflater: LayoutInflater = LayoutInflater.from(context)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      inflater.inflate(R.layout.content_item, parent, false).let { ActivityViewHolder(it) }

  override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
    val (activityClass, activityName) = activities[position]
    holder.activityName.apply {
      text = activityName
      setOnClickListener { context.startActivity(Intent(context, activityClass)) }
    }
  }

  override fun getItemCount() = activities.size
}

private class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  var activityName = itemView.findViewById(R.id.text_content) as TextView
}
