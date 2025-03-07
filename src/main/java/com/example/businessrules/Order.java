package com.example.businessrules;

public class Order {
    private final PaymentType paymentType;
    private final String product;

    public Order(PaymentType paymentType, String product) {
        this.paymentType = paymentType;
        this.product = product;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public String getProduct() {
        return product;
    }
}
