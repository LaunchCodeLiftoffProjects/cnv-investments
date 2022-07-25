package com.liftoff.cnvInvestments.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Transaction extends AbstractEntity {

    // linking each transaction to one investor
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="security_id")
    private Security security;

    private Date date;
    private String type;
    private int shares;
    private double cost;
    private double investedCap;

    public Transaction() {};

    public Transaction(User aUser, Security aSecurity, Date aDate, String aType, int shares, double cost, double investedCap) {
        super();
        this.user = aUser;
        this.security = aSecurity;
        this.date = aDate;
        this.type = aType;
        this.shares = shares;
        this.cost = cost;
        this.investedCap = investedCap;
    };

    // Getters & Setters

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


}
