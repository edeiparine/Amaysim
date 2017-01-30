package com.eman.exam.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eman.exam.R;
import com.eman.exam.pojo.Products;

import static com.eman.exam.Constants.checkIfFalse;

public class ProductsFragment extends Fragment {

    TextView tv_name;
    TextView tv_includedData;
    TextView tv_includedCredit;
    ImageView iv_includedInternationalTalk;


    ImageView iv_unlimitedText;
    ImageView iv_unlimitedTalk;
    ImageView iv_unlimitedInternationalText;
    ImageView iv_unlimitedInternationalTalk;

    TextView tv_price;

    Products products;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        products = Products.getInstance();
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View view) {
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        tv_includedData = (TextView) view.findViewById(R.id.tv_included_data);
        tv_includedCredit = (TextView) view.findViewById(R.id.tv_included_credit);
        tv_price = (TextView) view.findViewById(R.id.tv_price);

        iv_includedInternationalTalk = (ImageView) view.findViewById(R.id.iv_includedInternational_talk);
        iv_unlimitedText = (ImageView) view.findViewById(R.id.iv_unlimited_text);
        iv_unlimitedTalk = (ImageView) view.findViewById(R.id.iv_unlimited_talk);
        iv_unlimitedInternationalText = (ImageView) view.findViewById(R.id.iv_unlimited_international_text);
        iv_unlimitedInternationalTalk = (ImageView) view.findViewById(R.id.iv_unlimited_international_talk);

        setTextValues();
    }

    private void setTextValues() {
        String name = products.getName();
        String includedData = "Included Data: " + products.getIncludedData();
        String includedCredit = "Included Credit: " + products.getIncludedCredit();
        String includedInternationalTalk = products.getIncludedInternationalTalk();
        String unlimitedText = products.getUnlimitedText();
        String unlimitedTalk = products.getUnlimitedTalk();
        String unlimitedInternationalText = products.getUnlimitedInternationalText();
        String unlimitedInternationalTalk = products.getUnlimitedInternationalTalk();
        String price = products.getPrice();

        tv_name.setText(name);
        tv_name.setTextSize(50);

        tv_includedData.setText(includedData);
        tv_includedCredit.setText(includedCredit);
        checkIfFalse(getContext(), iv_includedInternationalTalk, includedInternationalTalk);
        checkIfFalse(getContext(), iv_unlimitedText, unlimitedText);
        checkIfFalse(getContext(), iv_unlimitedTalk, unlimitedTalk);
        checkIfFalse(getContext(), iv_unlimitedInternationalText, unlimitedInternationalText);
        checkIfFalse(getContext(), iv_unlimitedInternationalTalk, unlimitedInternationalTalk);
        tv_price.setText(price);

    }


}
