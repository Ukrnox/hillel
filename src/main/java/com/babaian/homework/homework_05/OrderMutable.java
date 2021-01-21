package com.babaian.homework.homework_05;

import java.time.LocalDate;
import java.util.Objects;

public class OrderMutable {
    private int orderId;
    private LocalDate deliveryDate;
    private Customer customer;
    private int customerId;
    private String address;

    public OrderMutable(int orderId, LocalDate deliveryDate, Customer customer, String address) {
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.customerId = this.customer.getCustomerId();
        this.address = address;
        this.orderId = orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return " Order# " + orderId +
                ":\n deliveryDate = " + deliveryDate +
                ",\n customer = " + customer +
                ",\n address = '" + address + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMutable that = (OrderMutable) o;
        return orderId == that.orderId &&
                customerId == that.customerId &&
                deliveryDate.equals(that.deliveryDate) &&
                customer.equals(that.customer) &&
                address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, deliveryDate, customer, customerId, address);
    }

}
