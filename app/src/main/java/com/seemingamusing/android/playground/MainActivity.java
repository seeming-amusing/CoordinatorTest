package com.seemingamusing.android.playground;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.seemingamusing.android.playground.bottomsheet.BottomSheetActivity;
import com.seemingamusing.android.playground.footer.FooterActivity;
import com.seemingamusing.android.playground.model.SampleActivity;
import com.seemingamusing.android.playground.topbar.TopBarActivity;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.samples_listing) RecyclerView mSamples;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    initializeContentView();
  }

  private void initializeContentView() {
    mSamples.setLayoutManager(new LinearLayoutManager(this));
    mSamples.setAdapter(new ActivitiesAdapter(this));
  }

  private static class ActivitiesAdapter extends RecyclerView.Adapter<ActivityViewHolder> {

    private final SampleActivity[] mActivities = new SampleActivity[] {
        new SampleActivity(FooterActivity.class, "Footer Sample"),
        new SampleActivity(BottomSheetActivity.class, "Bottom Sheet Sample"),
        new SampleActivity(TopBarActivity.class, "Top Bar Sample"),
    };
    private final Context mContext;
    private final LayoutInflater mInflater;

    private ActivitiesAdapter(Context context) {
      mContext = context;
      mInflater = LayoutInflater.from(context);
    }

    @Override public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = mInflater.inflate(R.layout.content_item, parent, false);
      return new ActivityViewHolder(view);
    }

    @Override public void onBindViewHolder(ActivityViewHolder holder, int position) {
      final SampleActivity activity = mActivities[position];
      holder.mActivityName.setText(activity.getActivityName());
      holder.mActivityName.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          mContext.startActivity(new Intent(mContext, activity.getActivityClass()));
        }
      });
    }

    @Override public int getItemCount() {
      return mActivities.length;
    }
  }

  public static final class ActivityViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.text_content) TextView mActivityName;

    public ActivityViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}