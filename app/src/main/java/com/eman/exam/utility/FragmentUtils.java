package com.eman.exam.utility;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentUtils {

    public static void clearAllFragment(FragmentManager fm) {
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public static void navigatToActivity(Activity activity, Class className) {
        Intent intent = new Intent(activity, className);
        // set the new task and clear flags
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }

    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragmentToBeAdded, int containerId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.addToBackStack("");
        transaction.add(containerId, fragmentToBeAdded);
        transaction.commit();
    }
}
