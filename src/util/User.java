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
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public User updateUser(User user) {
        // TODO update fn
        return user;
    }

    public void updateUser() {
        // update query
        int userIdToUpdate = 0;
        final String UPDATE_USER_QUERY = "UPDATE user_info SET name=?, email=?, username=?, gender=? where userID=?;";
        try (var statement = GetConnection.getConn().prepareStatement(UPDATE_USER_QUERY);) {
            statement.setString(1, this.getName());
            statement.setString(2, this.getGender());
            statement.setString(3, this.getEmail());
            statement.setString(4, this.getUsername());
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

    public static void addNewUser(String username, String name, String email, String password, String gender) {
        // add new user
        final String INSERT_USER = "INSERT INTO user_info (username, name, email, password, Gender)\r\n" + //
                "VALUES (?,?,?,?,?);";
        try (var statement = GetConnection.getConn().prepareStatement(INSERT_USER);) {
            statement.setString(1, username);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, gender);
            statement.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while adding the user: " + e.getMessage());
        }
    }
}