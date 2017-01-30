package com.eman.exam.pojo;


public class Accounts {

    String id;
    String type;

    String paymentType;
    String unbilledCharges;
    String nextBillingDate;
    String title;
    String firstName;
    String lastName;
    String dateOfBirth;
    String contactNumber;
    String emailAddress;
    String emailAddressVerified;
    String emailSubscriptionStatus;

    private static Accounts instance;

    private Accounts() {
    }

    public static Accounts getInstance() {
        // singleton
        if (instance == null) {
            instance = new Accounts();
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getUnbilledCharges() {
        return unbilledCharges;
    }

    public void setUnbilledCharges(String unbilledCharges) {
        this.unbilledCharges = unbilledCharges;
    }

    public String getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(String nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddressVerified() {
        return emailAddressVerified;
    }

    public void setEmailAddressVerified(String emailAddressVerified) {
        this.emailAddressVerified = emailAddressVerified;
    }

    public String getEmailSubscriptionStatus() {
        return emailSubscriptionStatus;
    }

    public void setEmailSubscriptionStatus(String emailSubscriptionStatus) {
        this.emailSubscriptionStatus = emailSubscriptionStatus;
    }
}
