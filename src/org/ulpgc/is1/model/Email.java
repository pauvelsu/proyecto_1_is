package org.ulpgc.is1.model;

public class Email {
    private String account;

    public Email(String account) {
        if (isValidEmail(account)) {
            this.account = account;
        } else {
            throw new IllegalArgumentException("Invalid email address: " + account);
        }
    }

    public String getAccount() {
        return account;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && !email.trim().isEmpty();
    }
    @Override
    public String toString() {
        return account;
    }
}

