package com.liftoff.cnvInvestments.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Security extends AbstractEntity{

    @NotNull
    private String securityName;

    @NotNull
    private String tickerCode;

    public Security() {};

    public Security(String aSecurity, String aTicker) {
        this.securityName = aSecurity;
        this.tickerCode = aTicker;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getTickerCode() {
        return tickerCode;
    }

    public void setTickerCode(String tickerCode) {
        this.tickerCode = tickerCode;
    }
}
