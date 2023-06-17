package util;

import java.util.Date;
import java.util.Locale.Category;

public class Transaction {
    private String type;
    private Date date;
    private double amount;
    private Category category;

    public Transaction(String type, Date date, double amount, Category category) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}