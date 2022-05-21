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
    private int shares;
    private int cost;

//    private int cost = costPrice * shares;


    public Transaction() {};

    public Transaction(User aUser, Security aSecurity, Date aDate, int numberOfShares, int cost) {
        super();
        this.user = aUser;
        this.security = aSecurity;
        this.date = aDate;
        this.shares = numberOfShares;
        this.cost = cost;
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

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

//    public int getCostPrice() {
//        return costPrice;
//    }
//
//    public void setCostPrice(int costPrice) {
//        this.costPrice = costPrice;
//    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
