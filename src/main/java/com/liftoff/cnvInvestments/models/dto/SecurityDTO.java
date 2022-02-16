package com.liftoff.cnvInvestments.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SecurityDTO {

    @NotNull
    @NotBlank
    private String securityName;

    @NotNull
    @NotBlank
    private String tickerCode;

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
