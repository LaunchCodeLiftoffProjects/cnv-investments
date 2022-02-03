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
    private int cost;
    private int currentPrice;

    public Portfolio() {};

    public Portfolio(User aUser, Security aSecurity, int numberOfShares, int cost, int currentPrice) {
        super();
        this.user = aUser;
        this.security = aSecurity;
        this.shares = numberOfShares;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}
