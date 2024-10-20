package org.ulpgc.is1.model;

import java.time.LocalDate;
import java.util.Date;

public class Purchase {
    private static int NEXT_ID = 0;
    private final int id;
    private LocalDate date;
    private Address deliveryAddress;
    private Discount discount;
    private Product product;
    private Payment payment;
    private Customer customer;

    public Purchase(int id, LocalDate date, Address deliveryAddress, Discount discount, Product product, Payment payment, Customer customer) {
        this.id = id;
        this.date = date;
        this.deliveryAddress = deliveryAddress;
        this.discount = discount;
        this.product = product;
        this.payment = payment;
        this.customer = customer;
    }

    public static int getNextId() {
        return NEXT_ID;
    }

    public static void setNextId(int nextId) {
        NEXT_ID = nextId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrice() {
        int new_price = product.getPrice();
        if (discount != null &&
                (date.isEqual(discount.getFrom()) || date.isAfter(discount.getFrom())) &&
                (date.isEqual(discount.getTo()) || date.isBefore(discount.getTo()))) {
            new_price -= (product.getPrice() * discount.getPercentage() / 100);
        }

        return new_price;
    }

}
