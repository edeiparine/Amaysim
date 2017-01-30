package com.eman.exam.pojo;


public class Products {

    String type;
    String id;
    String name;

    String includedData;
    String includedCredit;
    String includedInternationalTalk;
    String unlimitedText;
    String unlimitedTalk;
    String unlimitedInternationalText;
    String unlimitedInternationalTalk;
    String price;

    private static Products instance;

    private Products() {
    }

    public static Products getInstance() {
        // singleton
        if (instance == null) {
            instance = new Products();
        }
        return instance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncludedData() {
        return includedData;
    }

    public void setIncludedData(String includedData) {
        this.includedData = includedData;
    }

    public String getIncludedCredit() {
        return includedCredit;
    }

    public void setIncludedCredit(String includedCredit) {
        this.includedCredit = includedCredit;
    }

    public String getIncludedInternationalTalk() {
        return includedInternationalTalk;
    }

    public void setIncludedInternationalTalk(String includedInternationalTalk) {
        this.includedInternationalTalk = includedInternationalTalk;
    }

    public String getUnlimitedText() {
        return unlimitedText;
    }

    public void setUnlimitedText(String unlimitedText) {
        this.unlimitedText = unlimitedText;
    }

    public String getUnlimitedTalk() {
        return unlimitedTalk;
    }

    public void setUnlimitedTalk(String unlimitedTalk) {
        this.unlimitedTalk = unlimitedTalk;
    }

    public String getUnlimitedInternationalText() {
        return unlimitedInternationalText;
    }

    public void setUnlimitedInternationalText(String unlimitedInternationalText) {
        this.unlimitedInternationalText = unlimitedInternationalText;
    }

    public String getUnlimitedInternationalTalk() {
        return unlimitedInternationalTalk;
    }

    public void setUnlimitedInternationalTalk(String unlimitedInternationalTalk) {
        this.unlimitedInternationalTalk = unlimitedInternationalTalk;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
