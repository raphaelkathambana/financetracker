package util;

import java.sql.*;
import java.util.regex.Pattern;
public class User {
    private String name;
    private String email;
    private String password;
    private String username;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void addIncomeTransaction(int userId, double amount, String category, String date) {
        try (Connection connection = GetConnection.getConn();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Income (user_id, amount, category, date) VALUES (?, ?, ?, ?);");) {
            statement.setInt(1, userId);
            statement.setDouble(2, amount);
            statement.setString(3, category);
            statement.setString(4, date);
            statement.executeUpdate();
            System.out.println("Income transaction added successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while adding the income transaction: " + e.getMessage());
        }
    }

    // Retrieve expenses for a specific user from the database
    public static void getExpensesForUser(int userId) {
        try (Connection connection = GetConnection.getConn();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM Expense WHERE user_id = ?;");) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int expenseId = resultSet.getInt("expense_id");
                double amount = resultSet.getDouble("amount");
                String category = resultSet.getString("category");
                String date = resultSet.getString("date");

                System.out.println("Expense ID: " + expenseId);
                System.out.println("Amount: " + amount);
                System.out.println("Category: " + category);
                System.out.println("Date: " + date);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while retrieving expenses: " + e.getMessage());
        }
    }
    public static boolean patternMatches(String emailAddress, String regexPattern) {
    return Pattern.compile(regexPattern)
      .matcher(emailAddress)
      .matches();
}
}