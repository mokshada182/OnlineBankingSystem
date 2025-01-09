package com.bank.model;

import java.util.Date;

public class Transaction {
    private int transactionId; // Add if necessary
    private Date date;
    private String description;
    private double amount;

    // Default constructor
    public Transaction() {
    }

    // Parameterized constructor
    public Transaction(int transactionId, double amount, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;
        this.date = new Date(); // Set current date by default
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
