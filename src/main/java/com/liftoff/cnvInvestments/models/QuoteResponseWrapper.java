package com.liftoff.cnvInvestments.models;

public class QuoteResponseWrapper {

    private QuoteResponse quoteResponse;

    public QuoteResponseWrapper() {
    }

    public QuoteResponseWrapper(QuoteResponse quoteResponse) {
        this.quoteResponse = quoteResponse;
    }

    public QuoteResponse getQuoteResponse() {
        return quoteResponse;
    }

    public void setQuoteResponse(QuoteResponse quoteResponse) {
        this.quoteResponse = quoteResponse;
    }
}
