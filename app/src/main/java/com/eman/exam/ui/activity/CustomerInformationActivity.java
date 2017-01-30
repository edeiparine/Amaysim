package com.eman.exam.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.eman.exam.LoginActivity;
import com.eman.exam.R;
import com.eman.exam.pojo.Accounts;
import com.eman.exam.pojo.Products;
import com.eman.exam.pojo.Services;
import com.eman.exam.pojo.Subscriptions;
import com.eman.exam.ui.adapter.CusomerInformationAdapter;
import com.eman.exam.ui.fragment.ProductsFragment;
import com.eman.exam.ui.fragment.ServicesFragment;
import com.eman.exam.ui.fragment.SubscriptionsFragment;
import com.eman.exam.utility.ActivityUtils;
import com.eman.exam.utility.JSONFileLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.eman.exam.Constants.JSON_ATTRIBUTES;
import static com.eman.exam.Constants.JSON_AUTO_RENEWAL;
import static com.eman.exam.Constants.JSON_CONTACT_NUMBER;
import static com.eman.exam.Constants.JSON_CREDIT;
import static com.eman.exam.Constants.JSON_CREDIT_EXPIRY;
import static com.eman.exam.Constants.JSON_DATA;
import static com.eman.exam.Constants.JSON_DATA_USAGE_THRESHOLD;
import static com.eman.exam.Constants.JSON_DATE_OF_BIRTH;
import static com.eman.exam.Constants.JSON_EMAIL_ADDRESS;
import static com.eman.exam.Constants.JSON_EMAIL_ADDRESS_VERIFIED;
import static com.eman.exam.Constants.JSON_EMAIL_SUBSCRIPTION_STATUS;
import static com.eman.exam.Constants.JSON_EXPIRY_DATE;
import static com.eman.exam.Constants.JSON_FIRST_NAME;
import static com.eman.exam.Constants.JSON_ID;
import static com.eman.exam.Constants.JSON_INCLUDED;
import static com.eman.exam.Constants.JSON_INCLUDED_CREDIT;
import static com.eman.exam.Constants.JSON_INCLUDED_CREDIT_BALANCE;
import static com.eman.exam.Constants.JSON_INCLUDED_DATA;
import static com.eman.exam.Constants.JSON_INCLUDED_DATA_BALANCE;
import static com.eman.exam.Constants.JSON_INCLUDED_INTERNATIONAL_TALK;
import static com.eman.exam.Constants.JSON_INCLUDED_INTERNATIONAL_TALK_BALANCE;
import static com.eman.exam.Constants.JSON_INCLUDED_ROLLOVER_CREDIT_BALANCE;
import static com.eman.exam.Constants.JSON_INCLUDED_ROLLOVER_DATA_BALANCE;
import static com.eman.exam.Constants.JSON_LAST_NAME;
import static com.eman.exam.Constants.JSON_MSN;
import static com.eman.exam.Constants.JSON_NAME;
import static com.eman.exam.Constants.JSON_NEXT_BILLING_DATE;
import static com.eman.exam.Constants.JSON_PAYMENT_TYPE;
import static com.eman.exam.Constants.JSON_PRICE;
import static com.eman.exam.Constants.JSON_PRIMARY_SUBSCRIPTION;
import static com.eman.exam.Constants.JSON_TITLE;
import static com.eman.exam.Constants.JSON_TYPE;
import static com.eman.exam.Constants.JSON_UNBILLIED_CHARGES;
import static com.eman.exam.Constants.JSON_UNLIMITED_INTERNATIONAL_TALK;
import static com.eman.exam.Constants.JSON_UNLIMITED_INTERNATIONAL_TEXT;
import static com.eman.exam.Constants.JSON_UNLIMITED_TALK;
import static com.eman.exam.Constants.JSON_UNLIMITED_TEXT;
import static com.eman.exam.Constants.checkDateIfNull;
import static com.eman.exam.Constants.checkTextIfNull;

public class CustomerInformationActivity extends AppCompatActivity implements View.OnClickListener {

    Accounts accounts;
    Services services;
    Subscriptions subscriptions;
    Products products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        accounts = Accounts.getInstance();
        services = Services.getInstance();
        subscriptions = Subscriptions.getInstance();
        products = Products.getInstance();

        loadJSONAccounts();
        loadJSONServices();
        loadJSONSubscriptions();
        loadJSONProducts();

        initializeToolbar();
        initializeViewPager();
        initializeFAB();
    }

    private void loadJSONAccounts() {
        try {
            JSONObject obj = new JSONObject(JSONFileLoader.loadJSONFromAsset(this));
            JSONObject data = obj.getJSONObject(JSON_DATA);

            accounts.setId(data.getString(JSON_ID));
            accounts.setType(data.getString(JSON_TYPE));


            JSONObject attributes = data.getJSONObject(JSON_ATTRIBUTES);

            accounts.setPaymentType(attributes.getString(JSON_PAYMENT_TYPE));

            String unbilledCharges = attributes.getString(JSON_UNBILLIED_CHARGES);
            String nextBillingDate = attributes.getString(JSON_NEXT_BILLING_DATE);
            String emailAddressVerified = attributes.getString(JSON_EMAIL_ADDRESS_VERIFIED);
            String emailSubscriptionStatus = attributes.getString(JSON_EMAIL_SUBSCRIPTION_STATUS);

            accounts.setUnbilledCharges(checkTextIfNull(unbilledCharges));
            accounts.setNextBillingDate(checkTextIfNull(nextBillingDate));

            accounts.setTitle(attributes.getString(JSON_TITLE));
            accounts.setFirstName(attributes.getString(JSON_FIRST_NAME));
            accounts.setLastName(attributes.getString(JSON_LAST_NAME));
            accounts.setDateOfBirth(attributes.getString(JSON_DATE_OF_BIRTH));
            accounts.setContactNumber(attributes.getString(JSON_CONTACT_NUMBER));


            accounts.setEmailAddress(attributes.getString(JSON_EMAIL_ADDRESS));
            accounts.setEmailAddressVerified(emailAddressVerified);
            accounts.setEmailSubscriptionStatus(emailSubscriptionStatus);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadJSONServices() {
        try {
            JSONObject obj = new JSONObject(JSONFileLoader.loadJSONFromAsset(this));
            JSONArray jsonArray = obj.getJSONArray(JSON_INCLUDED);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String type = jsonObject.getString(JSON_TYPE);
                // attributes node
                JSONObject attrib = jsonObject.getJSONObject(JSON_ATTRIBUTES);
                String msn = attrib.getString(JSON_MSN);
                String credit = attrib.getString(JSON_CREDIT);
                String creditExpiry = attrib.getString(JSON_CREDIT_EXPIRY);
                String dataUsageThreshold = attrib.getString(JSON_DATA_USAGE_THRESHOLD);

                services.setType(type);
                services.setMsn(msn);
                services.setCredit(credit);
                services.setCreditExpiry(creditExpiry);
                services.setDataUsageThreshold(dataUsageThreshold);
                break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadJSONSubscriptions() {
        try {
            JSONObject obj = new JSONObject(JSONFileLoader.loadJSONFromAsset(this));
            JSONArray jsonArray = obj.getJSONArray(JSON_INCLUDED);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String type = jsonObject.getString(JSON_TYPE);

                // attributes node
                JSONObject attrib = jsonObject.getJSONObject(JSON_ATTRIBUTES);
                if (type.matches("subscriptions")) {
                    String includedDataBalance = attrib.getString(JSON_INCLUDED_DATA_BALANCE);
                    String includedCreditBalance = attrib.getString(JSON_INCLUDED_CREDIT_BALANCE);
                    String includedRollOverCreditBalance = attrib.getString(JSON_INCLUDED_ROLLOVER_CREDIT_BALANCE);
                    String includedRollOverDataBalance = attrib.getString(JSON_INCLUDED_ROLLOVER_DATA_BALANCE);
                    String includedInternationalTalkBalance = attrib.getString(JSON_INCLUDED_INTERNATIONAL_TALK_BALANCE);
                    String expiryDate = attrib.getString(JSON_EXPIRY_DATE);
                    String autoRenewal = attrib.getString(JSON_AUTO_RENEWAL);
                    String primarySubscription = attrib.getString(JSON_PRIMARY_SUBSCRIPTION);

                    subscriptions.setType(type.toUpperCase());
                    subscriptions.setIncludedDataBalance(checkTextIfNull(includedDataBalance)); // convert to dollars
                    subscriptions.setIncludedCreditBalance(checkTextIfNull(includedCreditBalance));
                    subscriptions.setIncludedRollOverCreditBalance(checkTextIfNull(includedRollOverCreditBalance));
                    subscriptions.setIncludedRollOverDataBalance(checkTextIfNull(includedRollOverDataBalance));
                    subscriptions.setIncludedInternationalTalkBalance(checkTextIfNull(includedInternationalTalkBalance));
                    subscriptions.setExpiryDate(checkDateIfNull(expiryDate));
                    subscriptions.setAutoRenewal(autoRenewal);
                    subscriptions.setPrimarySubscription(primarySubscription);
                    break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadJSONProducts() {
        try {
            JSONObject obj = new JSONObject(JSONFileLoader.loadJSONFromAsset(this));
            JSONArray jsonArray = obj.getJSONArray(JSON_INCLUDED);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String type = jsonObject.getString(JSON_TYPE);

                // attributes node
                JSONObject attrib = jsonObject.getJSONObject(JSON_ATTRIBUTES);
                if (type.matches("products")) {
                    String name = attrib.getString(JSON_NAME);
                    String includedData = attrib.getString(JSON_INCLUDED_DATA);
                    String includedCredit = attrib.getString(JSON_INCLUDED_CREDIT);
                    String includedInternationalTalk = attrib.getString(JSON_INCLUDED_INTERNATIONAL_TALK);
                    String unlimitedText = attrib.getString(JSON_UNLIMITED_TEXT);
                    String unlimitedTalk = attrib.getString(JSON_UNLIMITED_TALK);
                    String unlimitedInternationalText = attrib.getString(JSON_UNLIMITED_INTERNATIONAL_TEXT);
                    String unlimitedInternationalTalk = attrib.getString(JSON_UNLIMITED_INTERNATIONAL_TALK);
                    String price = attrib.getString(JSON_PRICE);

                    products.setType(type.toUpperCase());
                    products.setName(name);
                    products.setIncludedData(checkTextIfNull(includedData));
                    products.setIncludedCredit(checkTextIfNull(includedCredit));
                    products.setIncludedInternationalTalk(includedInternationalTalk);
                    products.setUnlimitedText(unlimitedText);
                    products.setUnlimitedTalk(unlimitedTalk);
                    products.setUnlimitedInternationalText(unlimitedInternationalText);
                    products.setUnlimitedInternationalTalk(unlimitedInternationalTalk);
                    products.setPrice(checkTextIfNull(price));
                    break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initializeFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    private void initializeToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome");
        setSupportActionBar(toolbar);
    }

    private void initializeViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        CusomerInformationAdapter adapter = new CusomerInformationAdapter(getSupportFragmentManager());
        adapter.addFragment(new ServicesFragment(), services.getType());
        adapter.addFragment(new SubscriptionsFragment(), subscriptions.getType());
        adapter.addFragment(new ProductsFragment(), products.getType());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            navigateToLoginPage();
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    private void navigateToLoginPage() {
        ActivityUtils.addActivity(this, LoginActivity.class);
        finish();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.fab) {
            ActivityUtils.addActivity(this, AccountsActivity.class);
        }
    }
}
