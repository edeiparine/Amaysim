package com.eman.exam.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eman.exam.R;
import com.eman.exam.pojo.Subscriptions;

import static com.eman.exam.Constants.checkIfFalse;

public class SubscriptionsFragment extends Fragment {

    TextView tv_includedDataBalance;
    TextView tv_includedCreditBalance;
    TextView tv_includedRollOverCreditBalance;
    TextView tv_includedRollOverDataBalance;
    TextView tv_includedInternationalTalkBalance;
    TextView tv_expiryDate;

    ImageView iv_autoRenewal;
    ImageView iv_primarySubscriptions;

    Subscriptions subscriptions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriptions, container, false);
        subscriptions = Subscriptions.getInstance();
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View view) {
        tv_includedDataBalance = (TextView) view.findViewById(R.id.tv_included_data_balance);
        tv_includedCreditBalance = (TextView) view.findViewById(R.id.tv_included_credit_balance);
        tv_includedRollOverCreditBalance = (TextView) view.findViewById(R.id.tv_inluded_rollover_credit_balance);
        tv_includedRollOverDataBalance = (TextView) view.findViewById(R.id.tv_inluded_rollover_credit_balance);
        tv_includedInternationalTalkBalance = (TextView) view.findViewById(R.id.tv_included_international_talk_balance);
        tv_expiryDate = (TextView) view.findViewById(R.id.tv_expiry_date);
        iv_autoRenewal = (ImageView) view.findViewById(R.id.iv_auto_renewal);
        iv_primarySubscriptions = (ImageView) view.findViewById(R.id.iv_primary_subscriptions);
        setTextValues();
    }

    private void setTextValues() {
        String includedDataBalance = subscriptions.getIncludedDataBalance();
        String includedCreditBalance = subscriptions.getIncludedCreditBalance();
        String includedRollOverCreditBalance = subscriptions.getIncludedRollOverCreditBalance();
        String includedRollOverDataBalance = subscriptions.getIncludedRollOverDataBalance();
        String includedInternationalTalkBalance = subscriptions.getIncludedInternationalTalkBalance();
        String expiryDate = subscriptions.getExpiryDate();
        String autoRenewal = subscriptions.getAutoRenewal();
        String primarySubscription = subscriptions.getPrimarySubscription();

        tv_includedDataBalance.setText(includedDataBalance);
        tv_includedCreditBalance.setText(includedCreditBalance);
        tv_includedRollOverCreditBalance.setText(includedRollOverCreditBalance);
        tv_includedRollOverDataBalance.setText(includedRollOverDataBalance);
        tv_includedInternationalTalkBalance.setText(includedInternationalTalkBalance);
        tv_expiryDate.setText(expiryDate);

        checkIfFalse(getContext(), iv_autoRenewal, autoRenewal);
        checkIfFalse(getContext(), iv_primarySubscriptions, primarySubscription);
    }
}
