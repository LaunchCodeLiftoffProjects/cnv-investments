package com.liftoff.cnvInvestments.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {


    private List<SecurityData> result = new ArrayList<>();

    public QuoteResponse(){}

    public List<SecurityData> getResult() {
        return result;
    }

    public void setResult(List<SecurityData> result) {
        this.result = result;
    }

    /*  private String quoteType;
    private double regularMarketPrice;
    private String displayName;
    private String symbol;

    private String errorMessage;

    public QuoteResponse(String quoteType, double regularMarketPrice, String displayName, String symbol) {
        this.quoteType = quoteType;
        this.regularMarketPrice = regularMarketPrice;
        this.displayName = displayName;
        this.symbol = symbol;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getErrorMessage() {
        return errorMessage;
    }*/




}

