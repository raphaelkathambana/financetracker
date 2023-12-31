package util;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class Transaction { // Declare the Transaction class
    private Category category; // Declare category variable
    private LocalDate date; // Declare date variable
    private long amount; // Declare amount variable

    public Transaction(String dateString, long amount, Category category) {
        this.date = LocalDate.parse(dateString);
        this.amount = amount;
        this.category = category;
    }

    public List<Transaction> getTransactionByCategory(List<Transaction> transactions, Category category) {
        // iterate over transactions and return only the transactions of the category
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equals(category)) {
                result.add(transaction);
            }
        }
        return result;
    }

    public void displayInfo() { // Declare displayInfo method
        System.out.println("Date: " + this.date + ", Amount: " + this.amount + ", Category: " + this.category); // Print details of transaction
    }

    public java.sql.Date getSqlDate() {
        return java.sql.Date.valueOf(this.date);
    }
    public static java.sql.Date getSqlDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    public static void saveToDB(int userID, String categoryID, long amount, LocalDate date) { 
        // code to save to mysql database
        String query = "INSERT INTO transaction_info (userID, categoryID, Amount,Date)VALUES(?, ?, ?, ?);";
        try (PreparedStatement statement = GetConnection.getConn().prepareStatement(query);) {
            statement.setInt(1, userID);
            statement.setString(2, categoryID);
            statement.setLong(3, amount);
            statement.setDate(4, getSqlDate(date));
            statement.executeUpdate();
            System.out.println("Transaction Saved.");
        } catch (SQLException e) {
            System.out.println("Error occurred during transaction: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {

        Transaction other = null;
        if (o instanceof Transaction) {
            other = (Transaction) o;
        } else {
            return false;
        }
        return this.date.equals(other.date) && this.amount == other.amount && this.category.equals(other.category);
    }

    public int hashCode() {
        return this.date.hashCode() + (int) this.amount + this.category.hashCode();
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

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}