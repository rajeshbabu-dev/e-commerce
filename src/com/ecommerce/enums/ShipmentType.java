package com.ecommerce.enums;

public enum ShipmentType {
    STANDARD(49),EXPRESS(99),SAMEDAY(199);

    private final double shippingcost;
    ShipmentType(double shippingcost) {
        this.shippingcost = shippingcost;
    }
    public double getShippingcost() {
        return shippingcost;
    }
}
