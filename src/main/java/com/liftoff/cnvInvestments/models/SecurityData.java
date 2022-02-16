package com.liftoff.cnvInvestments.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityData {

    private String language;
    private String region;
    private String quoteType;
    private String quoteSourceName;
    private String triggerable;
    private String currency;
    private String marketState;
    private String regularMarketChange;
    private String regularMarketChangePercent;
    private String regularMarketTime;
    private String regularMarketPrice;

    public SecurityData(){}

    public SecurityData(String regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public String getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(String regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }
}
