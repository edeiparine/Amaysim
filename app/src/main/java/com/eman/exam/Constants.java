package com.eman.exam;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import java.text.NumberFormat;

/**
 * Created by eman on 1/30/17.
 */

public class Constants {
    public static final String JSON_DATA = "data";
    public static final String JSON_INCLUDED = "included";

    public static final String JSON_ID = "id";
    public static final String JSON_TYPE = "type";
    public static final String JSON_ATTRIBUTES = "attributes";
    // Accounts
    public static final String JSON_PAYMENT_TYPE = "payment-type";
    public static final String JSON_UNBILLIED_CHARGES = "unbilled-charges";
    public static final String JSON_NEXT_BILLING_DATE = "next-billing-date";
    public static final String JSON_TITLE = "title";
    public static final String JSON_FIRST_NAME = "first-name";
    public static final String JSON_LAST_NAME = "last-name";
    public static final String JSON_DATE_OF_BIRTH = "date-of-birth";
    public static final String JSON_CONTACT_NUMBER = "contact-number";
    public static final String JSON_EMAIL_ADDRESS = "email-address";
    public static final String JSON_EMAIL_ADDRESS_VERIFIED = "email-address-verified";
    public static final String JSON_EMAIL_SUBSCRIPTION_STATUS = "email-subscription-status";
    // Services
    public static final String JSON_MSN = "msn";
    public static final String JSON_CREDIT = "credit";
    public static final String JSON_CREDIT_EXPIRY = "credit-expiry";
    public static final String JSON_DATA_USAGE_THRESHOLD = "data-usage-threshold";
    // Subsriptions
    public static final String JSON_INCLUDED_DATA_BALANCE = "included-data-balance";
    public static final String JSON_INCLUDED_CREDIT_BALANCE = "included-credit-balance";
    public static final String JSON_INCLUDED_ROLLOVER_CREDIT_BALANCE = "included-rollover-credit-balance";
    public static final String JSON_INCLUDED_ROLLOVER_DATA_BALANCE = "included-rollover-data-balance";
    public static final String JSON_INCLUDED_INTERNATIONAL_TALK_BALANCE = "included-international-talk-balance";
    public static final String JSON_EXPIRY_DATE = "expiry-date";
    public static final String JSON_AUTO_RENEWAL = "auto-renewal";
    public static final String JSON_PRIMARY_SUBSCRIPTION = "primary-subscription";
    // Products
    public static final String JSON_NAME = "name";
    public static final String JSON_INCLUDED_DATA = "included-data";
    public static final String JSON_INCLUDED_CREDIT = "included-credit";
    public static final String JSON_INCLUDED_INTERNATIONAL_TALK = "unlimited-international-talk";
    public static final String JSON_UNLIMITED_TEXT = "unlimited-text";
    public static final String JSON_UNLIMITED_TALK = "unlimited-talk";
    public static final String JSON_UNLIMITED_INTERNATIONAL_TEXT = "unlimited-international-text";
    public static final String JSON_UNLIMITED_INTERNATIONAL_TALK = "unlimited-international-talk";
    public static final String JSON_PRICE = "price";

    public static String formatStringToCurrency(String string) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        int convertedStringToInt = Integer.parseInt(string);
        String formattedCurrency = format.format(convertedStringToInt);
        return formattedCurrency;
    }

    public static void checkIfFalse(Context context, ImageView imageView, String string) {
        if (string.matches("false")) {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.cross));
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.check));
        }
    }

    public static String checkDateIfNull(String expiryDate) throws Exception {
        if (expiryDate.matches("null")) {
            return "Not Available";
        } else {
            return expiryDate;
        }
    }

    public static String checkTextIfNull(String string) {
        if (string.matches("null")) {
            return "Not Available";
        } else {
            return formatStringToCurrency(string);
        }
    }
}
