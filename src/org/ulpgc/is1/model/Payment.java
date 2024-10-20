package org.ulpgc.is1.model;

import java.time.LocalDate;
import java.util.Date;

public class Payment {
    private LocalDate date;
    private int amount;
    private String card;

    public Payment(LocalDate date, String card, int amount) {
        this.date = date;
        this.card = card;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
