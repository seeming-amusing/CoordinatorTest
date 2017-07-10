package com.seemingamusing.android.playground.model

import android.app.Activity

data class SampleActivity(val activityClass: Class<out Activity>, val activityName: String)