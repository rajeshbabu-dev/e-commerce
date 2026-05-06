package com.ecommerce.enums;

public enum DiscountType {
    PERCENTAGE,
    FLAT;

    double applyDiscount(double price, double value) {
        return switch (this) {
            case PERCENTAGE -> price - (price * value / 100);
            case FLAT -> value - price;

        };
    }
}
