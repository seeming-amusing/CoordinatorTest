package com.seemingamusing.android.playground.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.seemingamusing.android.playground.R;

public class MockedDataAdapter extends RecyclerView.Adapter<MockedDataAdapter.MovieHolder> {

  private final String[] mData;
  private final LayoutInflater mLayoutInflater;

  public MockedDataAdapter(Context context) {
    mData = context.getResources().getStringArray(R.array.mocked_data);
    mLayoutInflater = LayoutInflater.from(context);
  }

  @Override public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mLayoutInflater.inflate(R.layout.content_item, parent, false);
    return new MovieHolder(view);
  }

  @Override public void onBindViewHolder(MovieHolder holder, int position) {
    holder.mContent.setText(mData[position]);
  }

  @Override public int getItemCount() {
    return mData.length;
  }

  public static final class MovieHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.text_content) TextView mContent;

    public MovieHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}