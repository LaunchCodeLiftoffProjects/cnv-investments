package com.liftoff.cnvInvestments.models;

import java.util.ArrayList;

public class TransactionData {

      public static ArrayList<Transaction> findByUser(User aUser, Iterable<Transaction> allTransactions) {

        ArrayList<Transaction> results = new ArrayList<>();

        if (aUser.getId() == 1) {
            for (Transaction transaction : allTransactions) {
                results.add(transaction);
            }
        } else {
            for (Transaction transaction : allTransactions) {
                if (transaction.getUser().getId() == aUser.getId())
                results.add(transaction);
            }
        }

        return results;
    }

}
