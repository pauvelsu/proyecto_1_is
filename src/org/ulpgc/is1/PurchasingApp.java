package org.ulpgc.is1;

import org.ulpgc.is1.control.Control;
import org.ulpgc.is1.model.*;

import java.time.LocalDate;
import java.util.List;

public class PurchasingApp {
    public static void main(String[] args) {
        Control control = new Control();

        Email email1 = new Email("tabera.alberto@gmail.com");
        Email email2 = new Email("Antonio@ulpgc.es");

        Address address1 = new Address("Calle del Sol", 123, "Madrid", "28001");
        Address address2 = new Address("Calle Patagonia", 23, "Las Palmas de Gran Canaria", "25007");

        Customer customer1 = new Customer("Alberto", "Tabera Silva", email1, address1);
        Customer customer2 = new Customer("Jane", "Doe", email2, address2);

        if (control.addCustomer(customer1)) {
            System.out.println("Cliente registrado: " + customer1.getFirstName());
        } else {
            System.out.println("El cliente " + customer1.getFirstName() + " ya está registrado.");
        }

        if (control.addCustomer(customer2)) {
            System.out.println("Cliente registrado: " + customer2.getFirstName());
        } else {
            System.out.println("El cliente " + customer2.getFirstName() + " ya está registrado.");
        }

        Product product1 = new Product(1, "Camiseta", "Camiseta Negra", 20, ProductCategory.CLOTHING);
        Product product2 = new Product(2, "juguete", "juguete para niño", 15, ProductCategory.TOY);

        Discount discount1 = new Discount(LocalDate.now(), LocalDate.now().plusDays(1), 20);

        if (control.addProduct(product1)) {
            System.out.println("Producto añadido: " + product1.getName());
        } else {
            System.out.println("El producto " + product1.getName() + " ya está registrado.");
        }

        if (control.addProduct(product2)) {
            System.out.println("Producto añadido: " + product2.getName());
        } else {
            System.out.println("El producto " + product2.getName() + " ya está registrado.");
        }

        Payment payment1 = new Payment(LocalDate.now(), "Visa", 1200);

        control.makePurchase(customer1, product1, address1, discount1, payment1);
        control.makePurchase(customer1, product2, address1, discount1, payment1);

        showCustomerPurchases(control, customer1);
    }

    public static void showCustomerPurchases(Control control, Customer customer) {

        System.out.println("El cliente " + customer.getFirstName() + " tiene " + customer.getPurchases().size() + " compras.");
        System.out.println("*********************************************");
        System.out.println("Compras de " + customer.getFirstName() + " " + customer.getLastName() +
                " (email: " + customer.getEmail() + ")");
        System.out.println("*********************************************");

        List<Purchase> purchases = customer.getPurchases();
        for (int i = 0; i < purchases.size(); i++) {
            Purchase purchase = purchases.get(i);
            Product product = purchase.getProduct();
            Discount discount = purchase.getDiscount();
            Payment payment = purchase.getPayment();
            Address deliveryAddress = purchase.getDeliveryAddress();

            // Datos de la compra
            System.out.println("    Compra (cod. " + i + ")");
            System.out.println("--------------------------------------------");
            System.out.println("*) Datos de la compra:");
            System.out.println("|- Código compra: " + purchase.getId());
            System.out.println("|- Realizada el día: " + purchase.getDate());
            System.out.println("|- Punto de entrega: " + deliveryAddress.getStreet() + " número " +
                    deliveryAddress.getNumber() + " en " + deliveryAddress.getCity() + " (CP: " + deliveryAddress.getPostalCode() + ")");
            System.out.println("   |- Cantidad: " + payment.getAmount() + " euros    (fecha del pago: " + payment.getDate() + ")");
            System.out.println("|- Total de la compra: " + payment.getAmount() + " euros.");

            // Datos del producto
            System.out.println("\n*) Datos del producto:");
            System.out.println("|- Código: " + product.getId());
            System.out.println("|- Nombre: " + product.getName());
            System.out.println("|- Descripción: " + product.getDescription());
            System.out.println("|- Categoría: " + product.getCategory());
            System.out.println("|- Precio: " + purchase.getPrice() + " euros.");



            System.out.println("--------------------------------------------\n");
        }
    }
}
