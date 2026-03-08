package com.example.payments.gateway.impl;

public class SafeCashPayment {
    private final int amount;
    private final String user;

    public SafeCashPayment(int amount, String user) {
        this.amount = amount;
        this.user = user;
    }

    public String confirm() {
        return "SC#pay(" + user + "," + amount + ")";
    }
}