package com.eman.exam.pojo;


public class Services {
    String id;
    String type;
    String msn;
    String credit;
    String creditExpiry;
    String dataUsageThreshold;

    private static Services instance;

    private Services() {
    }

    public static Services getInstance() {
        // singleton
        if (instance == null) {
            instance = new Services();
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

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCreditExpiry() {
        return creditExpiry;
    }

    public void setCreditExpiry(String creditExpiry) {
        this.creditExpiry = creditExpiry;
    }

    public String getDataUsageThreshold() {
        return dataUsageThreshold;
    }

    public void setDataUsageThreshold(String dataUsageThreshold) {
        this.dataUsageThreshold = dataUsageThreshold;
    }
}
