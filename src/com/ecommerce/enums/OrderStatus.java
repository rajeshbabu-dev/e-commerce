package com.ecommerce.enums;

import java.lang.classfile.instruction.SwitchCase;

public enum OrderStatus {
    PLACED, CONFIRMED, SHIPPED, DELIVERED, CANCELLED;

    public boolean isFinalStatus(){
        return switch (this){
            case DELIVERED,CANCELLED -> true;
            default -> false;
        };
    }

}
