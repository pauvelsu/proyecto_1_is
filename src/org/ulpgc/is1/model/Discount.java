package org.ulpgc.is1.model;

import java.util.Date;

public class Discount {
    private Date from;
    private Date to;
    private int percentage;

    public Discount(Date from, Date to, int percentage) {
        this.from = from;
        this.to = to;
        this.percentage = percentage;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
