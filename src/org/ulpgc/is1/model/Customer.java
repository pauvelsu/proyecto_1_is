package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private Email email;
    private Address address;
    private List<Purchase> purchases;

    public Customer(String firstName, String lastName, Email email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.purchases = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - Email: " + email.toString() + ", Address: " + address.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Customer customer = (Customer) obj;

        return email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
