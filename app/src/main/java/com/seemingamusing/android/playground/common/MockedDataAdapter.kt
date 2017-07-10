package com.seemingamusing.android.playground.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.seemingamusing.android.playground.R

class MockedDataAdapter(context: Context) : RecyclerView.Adapter<MovieHolder>() {

  private val data = context.resources.getStringArray(R.array.mocked_data)
  private val inflater = LayoutInflater.from(context)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      inflater.inflate(R.layout.content_item, parent, false).let { MovieHolder(it) }

  override fun onBindViewHolder(holder: MovieHolder, position: Int) {
    holder.content.text = data[position]
  }

  override fun getItemCount() = data.size
}

class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  internal var content = itemView.findViewById(R.id.text_content) as TextView
}
