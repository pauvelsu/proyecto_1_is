package org.ulpgc.is1.model;

public class Email {
    private String address;

    public Email(String address) {
        if (isValidEmail(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (isValidEmail(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    @Override
    public String toString() {
        return address;
    }
}
