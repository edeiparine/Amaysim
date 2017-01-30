package com.eman.exam.pojo;

public class Subscriptions {

    String id;
    String type;

    String includedDataBalance;
    String includedCreditBalance;
    String includedRollOverCreditBalance;
    String includedRollOverDataBalance;
    String includedInternationalTalkBalance;
    String expiryDate;
    String autoRenewal;
    String primarySubscription;

    private static Subscriptions instance;

    private Subscriptions() {
    }

    public static Subscriptions getInstance() {
        // singleton
        if (instance == null) {
            instance = new Subscriptions();
        }
        return instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIncludedDataBalance() {
        return includedDataBalance;
    }

    public void setIncludedDataBalance(String includedDataBalance) {
        this.includedDataBalance = includedDataBalance;
    }

    public String getIncludedCreditBalance() {
        return includedCreditBalance;
    }

    public void setIncludedCreditBalance(String includedCreditBalance) {
        this.includedCreditBalance = includedCreditBalance;
    }

    public String getIncludedRollOverCreditBalance() {
        return includedRollOverCreditBalance;
    }

    public void setIncludedRollOverCreditBalance(String includedRollOverCreditBalance) {
        this.includedRollOverCreditBalance = includedRollOverCreditBalance;
    }

    public String getIncludedRollOverDataBalance() {
        return includedRollOverDataBalance;
    }

    public void setIncludedRollOverDataBalance(String includedRollOverDataBalance) {
        this.includedRollOverDataBalance = includedRollOverDataBalance;
    }

    public String getIncludedInternationalTalkBalance() {
        return includedInternationalTalkBalance;
    }

    public void setIncludedInternationalTalkBalance(String includedInternationalTalkBalance) {
        this.includedInternationalTalkBalance = includedInternationalTalkBalance;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(String autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public String getPrimarySubscription() {
        return primarySubscription;
    }

    public void setPrimarySubscription(String primarySubscription) {
        this.primarySubscription = primarySubscription;
    }


}
