package com.eman.exam.utility;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class KeyboardUtils {
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(
                        activity.INPUT_METHOD_SERVICE);

        // If no view is focused, an NPE will be thrown
        View focusedView = activity.getCurrentFocus();
        if (focusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
