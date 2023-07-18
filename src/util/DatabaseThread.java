package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gui.Login;

public class DatabaseThread extends Thread {
    private User currentUser;
    private Login login;
    private boolean loggedIn;

    public Login getLogin() {
        return login;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public DatabaseThread(Login login) {
        this.login = login;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public DatabaseThread() {
        this.setName("AuthenticationThread");
        this.currentUser = null;
        this.loggedIn = false;
    }

    @Override
    public void run() {
        // Run the thread continuously until the program is terminated or the user logs
        // out
        while (true) {
            // Check if the user is logged in
            if (loggedIn && currentUser != null) {
                // Fetch the user's data from the database
                fetchUserData();

                // Fetch the user's transactions from the database
                fetchUserTransactions();

                // Fetch the user's budget from the database
                fetchUserBudget();
            }

            // Sleep for a certain period of time before fetching the data again
            try {
                Thread.sleep(60000); // Sleep for 1 minute (adjust as needed)
            } catch (InterruptedException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "User Logged Out", "Log Out",
                        JOptionPane.INFORMATION_MESSAGE);
                this.interrupt();        
                break;
            }
        }
    }

    public void logoutUser() {
        // Perform any necessary clean-up operations or log-out logic
        this.currentUser = null;
        this.loggedIn = false;
    }

    private void fetchUserData() {
        // Fetch the user's data from the database
        int userId = currentUser.getId();
        String query = "SELECT userId, username, email, Gender FROM user_info WHERE userId = ?;";

        try (var connection = GetConnection.getConn();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int fetchedUserId = resultSet.getInt("userId");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String gender = resultSet.getString("Gender");

                // Update the User object with the fetched data
                currentUser.setUsername(username);
                currentUser.setEmail(email);
                currentUser.setGender(gender);

                // Print the fetched data for testing
                System.out.println("Fetched User Data:");
                System.out.println("User ID: " + fetchedUserId);
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
                System.out.println("Gender: " + gender);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching user data: " + e.getMessage());
        }
    }

    private void fetchUserTransactions() {
        int userId = currentUser.getId();
        String query = "SELECT transactionID, categoryID, Amount, Date FROM transaction_info WHERE userID = ?;";

        List<Transaction> transactions = new ArrayList<>(); // Declare the list to store the fetched transactions

        try (var connection = GetConnection.getConn();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transactionID");
                String categoryId = resultSet.getString("categoryID");
                long amount = resultSet.getLong("Amount");
                java.sql.Date date = resultSet.getDate("Date");

                // Create a Transaction object with the fetched data
                Transaction transaction = new Transaction(date.toString(), amount,
                        Category.getCategoryFromId(categoryId));

                // Add the transaction to the list
                transactions.add(transaction);

                // Print the fetched transaction data for testing
                System.out.println("Fetched Transaction Data:");
                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Category ID: " + categoryId);
                System.out.println("Amount: " + amount);
                System.out.println("Date: " + date);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching user transactions: " + e.getMessage());
        }

        // Do something with the list of fetched transactions outside the try-catch
        // block
        // For example, you can store the list in a variable or pass it to another
        // method for further processing
        // ...
    }

    private List<Budget> fetchUserBudget() {
        int userId = currentUser.getId();
        Budget budget = null;
        List<Budget> budgetList = new ArrayList<>();

        String budgetQuery = "SELECT budgetID, budgetName, budgetAmount, startDate, endDate FROM budget WHERE userID = ?;";
        String progressQuery = "SELECT categoryID, budgetAmount, usedAmount FROM budget_progress WHERE userID = ? AND budgetID = ?;";

        try (var connection = GetConnection.getConn();
                PreparedStatement budgetStatement = connection.prepareStatement(budgetQuery);
                PreparedStatement progressStatement = connection.prepareStatement(progressQuery)) {

            // Fetch budget data
            budgetStatement.setInt(1, userId);
            ResultSet budgetResult = budgetStatement.executeQuery();

            while (budgetResult.next()) {
                int budgetId = budgetResult.getInt("budgetID");
                String budgetName = budgetResult.getString("budgetName");
                String startDate = budgetResult.getString("startDate");
                String endDate = budgetResult.getString("endDate");

                budget = new Budget(budgetName, startDate, endDate);

                // Fetch budget progress data
                progressStatement.setInt(1, userId);
                progressStatement.setInt(2, budgetId);
                ResultSet progressResult = progressStatement.executeQuery();

                while (progressResult.next()) {
                    String categoryId = progressResult.getString("categoryID");
                    long categoryBudgetAmount = progressResult.getLong("budgetAmount");
                    long categoryAmountSpent = progressResult.getLong("usedAmount");

                    Category category = Category.getCategoryFromId(categoryId);
                    budget.allocateCategoryBudget(category, categoryBudgetAmount);
                    budget.trackExpense(category, categoryAmountSpent);
                }
                budget.generateBudgetReport();
                budgetList.add(budget);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching user budget: " + e.getMessage());
        }
        return budgetList;
    }
    public List<Budget> getUserBudgets() {
        return fetchUserBudget();
    }
}