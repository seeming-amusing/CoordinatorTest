package com.seemingamusing.android.playground.model;

import android.app.Activity;

public class SampleActivity {

  private final Class<? extends Activity> mActivityClass;
  private final String mActivityName;

  public SampleActivity(Class<? extends Activity> activityClass, String activityName) {
    mActivityClass = activityClass;
    mActivityName = activityName;
  }

  public Class<? extends Activity> getActivityClass() {
    return mActivityClass;
  }

  public String getActivityName() {
    return mActivityName;
  }
}