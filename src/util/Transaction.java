package util;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.*;


        
public class Transaction { // Declare the Transaction class
    
            static String  host = "jdbc:mysql://localhost/transaction";  
            static String uName = " ";
            static String uPass = " ";

              /**
             * @return
             * @throws SQLException
             */
            public static Connection getConnection() throws SQLException {
             return DriverManager.getConnection(host, uName, uPass);
    }
    
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
        System.out.println("Type: " + this.type + ", Date: " + this.date + ", Amount: " + this.amount + ", Category: " + this.category); // Print details of transaction
    }

    public java.sql.Date getSqlDate() {
        return java.sql.Date.valueOf(this.date);
    }
    public void saveToDB() { // Declare saveToDB method
        // code to save to mysql database // Function body
         try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Finance tracker ( type, date, amount, category) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, type);
            statement.setDate(2, date);
            statement.setDouble(3, amount);
            statement.setCategory(4, category);
            statement.executeUpdate();
            System.out.println("Transaction complete.");
        } catch (SQLException e) {
            System.out.println("Error occurred during transaction: " + e.getMessage());
        }
    }
       
    public void viewTransactions(){// viewing transactions made
           
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM Expense WHERE type = ?")) {
            statement.setDate(1, date);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int type = rs.getInt("type");
                double amount = rs.getDouble("amount");
                String category = rs.getString("category");
                String date = rs.getString("date");

                System.out.println("Type: " + type);
                System.out.println("Date: " + date);
                System.out.println("Amount: " + amount);
                System.out.println("Category: " + category);
             
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while retrieving transaction: " + e.getMessage());
        }
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