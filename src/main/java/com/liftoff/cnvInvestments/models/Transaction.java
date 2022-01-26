package com.liftoff.cnvInvestments.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Transaction extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String security;
    private Date date;
    private int shares;
    private int cost;


    public Transaction() {};

    public Transaction(User aUser, String securityName, Date aDate, int numberOfShares, int cost) {
        super();
        this.user = aUser;
        this.security = securityName;
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

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
