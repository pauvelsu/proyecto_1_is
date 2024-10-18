package org.ulpgc.is1.control;

import org.ulpgc.is1.model.Customer;
import org.ulpgc.is1.model.Product;
import org.ulpgc.is1.model.Purchase;

import java.util.ArrayList;
import java.util.List;

public class Control {
    private List<Customer> customers;
    private List<Product>products;

    public Control() {
        customers = new ArrayList<>();
        products = new ArrayList<>();
    }
    public boolean addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
            return true;
        } else {
            System.out.println("Customer already exists.");
            return false;
        }
    }

    public boolean addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            return true;
        } else {
            System.out.println("Product already exists.");
            return false;
        }
    }
    public boolean makePurchase(Customer customer, Product product) {
        if (customers.contains(customer) && products.contains(product)) {
            Purchase purchase = new Purchase(customer, product);
            customer.addPurchase(purchase);
            return true;
        } else {
            System.out.println("Either customer or product not found.");
            return false;
        }
    }
    public void showCustomerPurchases(Customer customer) {
        if (customers.contains(customer)) {
            List<Purchase> purchases = customer.getPurchases();
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        } else {
            System.out.println("Customer not found.");
        }
    }
}