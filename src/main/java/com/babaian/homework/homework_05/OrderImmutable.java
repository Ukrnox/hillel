package com.babaian.homework.homework_05;

import java.util.Date;
import java.util.Objects;

public class OrderImmutable {
    private final int orderId;
    private Date deliveryDate;
    private final int customerId;
    private final String address;

    public OrderImmutable(int orderId, Date deliveryDate, int customerId, String address) {
        this.orderId = orderId;
        this.deliveryDate = new Date(deliveryDate.getTime());
        this.customerId = customerId;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getDeliveryDate() {
        return deliveryDate = new Date(deliveryDate.getTime());
    }


    public int getCustomerId() {
        return customerId;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return " OrderId = " + orderId +
                ",\n deliveryDate = " + deliveryDate +
                ",\n customerId = " + customerId +
                ",\n address = '" + address + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderImmutable that = (OrderImmutable) o;
        return orderId == that.orderId && customerId == that.customerId &&
                deliveryDate.equals(that.deliveryDate) &&
                address.equals(that.address) &&
                Objects.equals(deliveryDate, that.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, deliveryDate, customerId, address, deliveryDate);
    }

}
