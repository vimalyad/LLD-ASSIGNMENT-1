package com.example.payments.client;

import com.example.payments.gateway.impl.SafeCashPayment;

public class SafeCashClient {
    public SafeCashPayment createPayment(int amount, String user) {
        return new SafeCashPayment(amount, user);
    }
}