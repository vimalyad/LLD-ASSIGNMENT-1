package utils.impl;

import utils.behaviours.IPaymentGateway;

public class PaymentGateway implements IPaymentGateway {
    public String charge(String studentId, double amount) {
        return "TXN-9001";
    }
}
