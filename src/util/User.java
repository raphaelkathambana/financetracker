package util;

import java.sql.*;
import java.util.regex.Pattern;

public class User {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public User updateUser(User user) {
        // TODO update fn
        return user;
    }

    public void updateUser(String newName, String newEmail, String newUsername, String newGender) {
        // update query
        int userIdToUpdate = 0;
        final String UPDATE_USER_QUERY = "UPDATE user_info SET username=?, email=?, username=?, gender=? where userID=?;";
        try (var statement = GetConnection.getConn().prepareStatement(UPDATE_USER_QUERY);) {
            statement.setString(1, newName);
            statement.setString(2, newGender);
            statement.setString(3, newEmail);
            statement.setString(4, newUsername);
            statement.setInt(5, userIdToUpdate);
            statement.executeUpdate();
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while updating the user: " + e.getMessage());
        }
    }

    public void deleteUser() {
        // delete query
        int userIdToDelete = 0;
        final String DELETE_USER_QUERY = "DELETE FROM users WHERE id=?;";
        try (var statement = GetConnection.getConn().prepareStatement(DELETE_USER_QUERY);) {
            statement.setInt(1, userIdToDelete);
            statement.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting the user: " + e.getMessage());
        }
    }

    public static User getUser(String username, String password) {
        User user = null;
        var query = "SELECT * FROM user_info WHERE username = ? and password = ?;";

        try (var stat = GetConnection.getConn().prepareStatement(query);) {
            stat.setString(1, username);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("email"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while retrieving user: " + e.getMessage());
        }
        return user;
    }

    public static User authenticateUser(String username, String password) {
        User user = null;
        var query = "SELECT * FROM user_info WHERE username = ? and password = ?;";

        try (var stat = GetConnection.getConn().prepareStatement(query);) {
            stat.setString(1, username);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString("username"), rs.getString("email"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        return user;
    }

    public static void addNewUser(String text, String text2, String text3) {
        // add new user
        
            final String INSERT_USER="INSERT INTO `user_info` (`username`, `email`,`password`) VALUES (?,?,?);";
            try (var statement = GetConnection.getConn().prepareStatement(INSERT_USER);) {
                statement.setString(1, text);
                statement.setString(2, text2);
                statement.setString(3, text3);
                statement.executeUpdate();
                System.out.println("User added successfully.");
            } catch (SQLException e) {
                System.out.println("Error occurred while adding the user: " + e.getMessage());
            }
    }
}