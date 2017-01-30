package com.eman.exam.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eman.exam.Constants;
import com.eman.exam.R;
import com.eman.exam.pojo.Accounts;

public class AccountsActivity extends AppCompatActivity {

    TextView tv_fullname;
    TextView tv_paymentType;
    TextView tv_unbilledCharges;
    TextView tv_nextBillingDate;
    TextView tv_dateOfBirth;
    TextView tv_contactNumber;
    TextView tv_emailAddress;
    ImageView iv_emailAddressVerified;
    ImageView iv_emailSubscriptionStatus;

    Accounts accounts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        accounts = Accounts.getInstance();
        initializeToolbar();
        initializeComponents();
    }

    private void initializeToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        createCollapsingToolbar();
        loadBackdrop();
    }

    private void createCollapsingToolbar() {
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.backdrop).centerCrop().into(imageView);
    }

    private void initializeComponents() {
        tv_fullname = (TextView) findViewById(R.id.tv_fullname);
        tv_paymentType = (TextView) findViewById(R.id.tv_paymentType);
        tv_unbilledCharges = (TextView) findViewById(R.id.tv_unbilledCharges);
        tv_nextBillingDate = (TextView) findViewById(R.id.tv_nextBillingDate);
        tv_dateOfBirth = (TextView) findViewById(R.id.tv_dateOfBirth);
        tv_contactNumber = (TextView) findViewById(R.id.tv_contactNumber);
        tv_emailAddress = (TextView) findViewById(R.id.tv_emailAddress);
        iv_emailAddressVerified = (ImageView) findViewById(R.id.iv_emailAddressVerified);
        iv_emailSubscriptionStatus = (ImageView) findViewById(R.id.iv_emailSubscriptionStatus);
        setTextViewValues();
    }

    private void setTextViewValues() {

        String fullName = accounts.getTitle() + "."
                + accounts.getLastName() + ", "
                + accounts.getFirstName();

        String paymentType = accounts.getPaymentType().toUpperCase();
        String unbilledCharges = accounts.getUnbilledCharges();
        String nextBillingDate = accounts.getNextBillingDate();
        String dateOfBirth = accounts.getDateOfBirth();
        String contactNumber = accounts.getContactNumber();
        String emailAddress = accounts.getEmailAddress();
        String emailAddressVerified = accounts.getEmailAddressVerified();
        String emailSubscriptionStatus = accounts.getEmailSubscriptionStatus();

        tv_fullname.setText(fullName);
        tv_paymentType.setText(paymentType);
        tv_unbilledCharges.setText(unbilledCharges);
        tv_nextBillingDate.setText(nextBillingDate);
        tv_dateOfBirth.setText(dateOfBirth);
        tv_contactNumber.setText(contactNumber);
        tv_emailAddress.setText(emailAddress);
        Constants.checkIfFalse(this, iv_emailAddressVerified, emailAddressVerified);
        Constants.checkIfFalse(this, iv_emailSubscriptionStatus, emailSubscriptionStatus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
