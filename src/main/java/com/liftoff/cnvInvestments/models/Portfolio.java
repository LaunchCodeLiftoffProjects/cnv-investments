package com.liftoff.cnvInvestments.models;

import javax.persistence.*;

@Entity
public class Portfolio extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="security_id")
    private Security security;

    private int shares;
    private double investedCap;
    private double cost;
    private double currentPrice;

    public Portfolio() {};

    public Portfolio(User aUser, Security aSecurity, int shares, double investedCap, double cost, double currentPrice) {
        super();
        this.user = aUser;
        this.security = aSecurity;
        this.shares = shares;
        this.investedCap = investedCap;
        this.cost = cost;
        this.currentPrice = currentPrice;
    };

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getInvestedCap() {
        return investedCap;
    }

    public void setInvestedCap(double investedCap) {
        this.investedCap = investedCap;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
