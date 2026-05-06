package com.ecommerce.enums;

public enum OrderPriority {
    LOW(5),
    MEDIUM(3),
    HIGH(1);
    private final int DeliveryDays;

    OrderPriority(int getDeliveryDays) {
        this.DeliveryDays = getDeliveryDays;
    }
    public int getDeliveryDays() {
        return this.DeliveryDays;
    }


}
