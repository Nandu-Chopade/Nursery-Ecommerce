package com.nursery.payment;

public enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    PAYPAL("PayPal"),
    GOOGLE_PAY("Google Pay"),
    APPLE_PAY("Apple Pay"),
    CASH("Cash"),
    BANK_TRANSFER("Bank Transfer");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
