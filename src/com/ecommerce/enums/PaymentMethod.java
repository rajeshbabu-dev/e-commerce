package com.ecommerce.enums;

public enum PaymentMethod {
    CREDIT_CARD(true),
    DEBIT_CARD(false),
    UPI(true),
    NET_BANKING(true),
    CASH_ON_DELIVERY(false),;

    private final boolean requiresOnlineProcessing;

    PaymentMethod(boolean requiresOnlineProcessing) {
        this.requiresOnlineProcessing = requiresOnlineProcessing;
    }

    public boolean requiresOnlineProcessing() {
        return requiresOnlineProcessing;
    }
}
