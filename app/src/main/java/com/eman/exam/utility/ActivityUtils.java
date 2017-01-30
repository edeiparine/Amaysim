package com.eman.exam.utility;

import android.app.Activity;
import android.content.Intent;

public class ActivityUtils {
    public static void addActivity(Activity activity, Class className) {
        Intent myIntent = new Intent(activity, className);
        activity.startActivity(myIntent);
    }
}
