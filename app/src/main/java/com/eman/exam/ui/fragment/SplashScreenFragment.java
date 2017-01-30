package com.eman.exam.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eman.exam.R;
import com.eman.exam.ui.activity.CustomerInformationActivity;
import com.eman.exam.utility.ActivityUtils;

public class SplashScreenFragment extends Fragment {

    Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splashscreen, container, false);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToMainPage();
            }

        }, 1000);
        return view;
    }

    private void navigateToMainPage() {
        ActivityUtils.addActivity(getActivity(), CustomerInformationActivity.class);
    }
}
