package util;

import java.time.LocalDate;

public class Transaction { // Declare the Transaction class
    private String type; // Declare Type variable
    private Category category; // Declare category variable
    private LocalDate date; // Declare date variable
    private double amount; // Declare amount variable

    public Transaction(String type, String dateString, double amount, Category category) {
        this.type = type;
        this.date = LocalDate.parse(dateString);
        this.amount = amount;
        this.category = category;
    }

    public void displayInfo() { // Declare displayInfo method
        System.out.println("Type: " + this.type + ", Date: " + this.date + ", Amount: " + this.amount + ", Category: "
                + this.category); // Print details of transaction
    }

    public java.sql.Date getSqlDate() {
        return java.sql.Date.valueOf(this.date);
    }
    public void saveToDB() { // Declare saveToDB method
        // code to save to mysql database // Function body
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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