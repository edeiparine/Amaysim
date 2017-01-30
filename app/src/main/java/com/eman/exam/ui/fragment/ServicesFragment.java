package com.eman.exam.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eman.exam.Constants;
import com.eman.exam.R;
import com.eman.exam.pojo.Services;


public class ServicesFragment extends Fragment {

    TextView tv_msn;
    TextView tv_credit;
    TextView tv_creditExpiry;
    ImageView iv_dataUsageThreshold;

    Services services;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);
        services = Services.getInstance();
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View view) {
        tv_msn = (TextView) view.findViewById(R.id.tv_msn);
        tv_credit = (TextView) view.findViewById(R.id.tv_credit);
        tv_creditExpiry = (TextView) view.findViewById(R.id.tv_creditExpiry);
        iv_dataUsageThreshold = (ImageView) view.findViewById(R.id.iv_dataUsageThreshold);
        setTextValues();
    }

    private void setTextValues() {
        String msn = services.getMsn();
        String credit = services.getCredit();
        String creditExpiry = services.getCreditExpiry();
        String dataUsageThreshold = services.getDataUsageThreshold();

        tv_msn.setText(msn);
        tv_credit.setText(Constants.formatStringToCurrency(credit));
        tv_creditExpiry.setText(creditExpiry);
        Constants.checkIfFalse(getContext(), iv_dataUsageThreshold, dataUsageThreshold);
    }


}
