package com.liftoff.cnvInvestments.models;

import java.util.ArrayList;

public class PortfolioData {

    public static ArrayList<Portfolio> findByUser(User aUser, Iterable<Portfolio> portfolio) {

        ArrayList<Portfolio> results = new ArrayList<>();

        if (aUser.getId() == 1) {
            for (Portfolio portfolioEntry : portfolio) {
                results.add(portfolioEntry);
            }
        } else {
            for (Portfolio portfolioEntry : portfolio) {
                if (portfolioEntry.getUser().getId() == aUser.getId())
                    results.add(portfolioEntry);
            }
        }

        return results;
    }

}
