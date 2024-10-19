package org.ulpgc.is1.model;

import java.util.Date;

public class Purchase {
    private static int NEXT_ID = 0;
    private final int id;
    private Date date;
    private Address deliveryAddress;
    private Discount discount;
    private Product product;
    private Payment payment;
    private Customer customer;

    public Purchase(int id, Date date, Address deliveryAddress, Discount discount, Product product, Payment payment, Customer customer) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public int getPrice(){
        int new_price = 0;
        if(discount != null &&
                (date.equals(discount.getFrom())||date.after(discount.getFrom()))&&
                date.equals(discount.getTo())||date.before(discount.getTo())){
            new_price += product.getPrice() - (product.getPrice()*discount.getPercentage()/100);
        } else{
            new_price = product.getPrice();
        }

        return new_price;
    }
}
