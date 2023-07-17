package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Budget {
    private String startDate;
    private String endDate;
    private long totalBudgetAmount;
    private long totalExpenses;
    private Map<Category, List<Long>> allocatedCategories;
    private String budgetName;

    public Budget(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBudgetAmount = 0;
        this.totalExpenses = 0;
        this.allocatedCategories = new HashMap<>();
    }

    public Budget(String name, String startDate, String endDate) {
        this.budgetName = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBudgetAmount = 0;
        this.totalExpenses = 0;
        this.allocatedCategories = new HashMap<>();
    }

    public void setTotalBudgetAmount(long totalIncome) {
        this.totalBudgetAmount = totalIncome;
    }

    public void allocateCategoryBudget(Category category, long amount) {
        totalBudgetAmount += amount;
        List<Long> amountMap = new ArrayList<>();
        amountMap.add(amount);
        amountMap.add((long) 0);
        allocatedCategories.put(category, amountMap);
    }

    public void trackExpense(Category category, long expenseAmount) {
        totalExpenses += expenseAmount;

        if (allocatedCategories.containsKey(category)) {
            long allocatedAmount = allocatedCategories.get(category).get(0);
            long remainingBudget = allocatedAmount - expenseAmount;

            if (remainingBudget < 0) {
                System.out.println("You have exceeded the budget for category: " + category);
                // Generate an alert or notification for exceeding the budget
            }

            List<Long> amountMap = new ArrayList<>();
            amountMap.add(remainingBudget);
            amountMap.add(expenseAmount);

            allocatedCategories.put(category, amountMap);
        }
    }

    public void generateBudgetReport() {
        System.out.println("Budget Report:");
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Total Budget Amount: " + totalBudgetAmount);
        System.out.println("Total Expenses: " + totalExpenses);

        for (Map.Entry<Category, List<Long>> entry : allocatedCategories.entrySet()) {
            Category category = entry.getKey();
            List<Long> allocatedAmount = entry.getValue();

            System.out.println("Category: " + category.getName());
            System.out.println("Allocated Amount: " + (allocatedAmount.get(0) + allocatedAmount.get(1)));
            System.out.println("Remaining Budget: " + allocatedAmount.get(0));
            System.out.println();
        }
    }

    public void saveToDB() {
        var saveBudget = "INSERT INTO budget ( budgetName, userID, budgetAmount, startDate, endDate ) VALUES ( ?, ?, ?, ?, ? );";
        var saveBudgetCategories = "INSERT INTO budget_progress ( budgetID, userID, categoryID, budgetAmount, usedAmount, Balance ) VALUES ( ?, ?, ?, ?, ?, ? );";

        try (var statBudget = GetConnection.getConn().prepareStatement(saveBudget);
                var statBudgetCategories = GetConnection.getConn().prepareStatement(saveBudgetCategories);) {
            statBudget.setString(1, "budgetName");
            statBudget.setInt(2, 1);
            statBudget.setLong(3, this.totalBudgetAmount);
            statBudget.setString(4, this.startDate);
            statBudget.setString(5, this.endDate);
            statBudget.executeUpdate();

            for (Map.Entry<Category, List<Long>> entry : allocatedCategories.entrySet()) {
                Category category = entry.getKey();
                List<Long> allocatedAmount = entry.getValue();
                statBudgetCategories.setInt(1, getBudgetId("budgetName"));
                statBudgetCategories.setInt(2, 1);
                statBudgetCategories.setString(3, category.getId());
                statBudgetCategories.setLong(4, allocatedAmount.get(0) + allocatedAmount.get(1));
                statBudgetCategories.setLong(5, allocatedAmount.get(1));
                statBudgetCategories.setLong(6, allocatedAmount.get(0));
                statBudgetCategories.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error Saving the budget: " + e.getMessage());
        }
    }

    private int getBudgetId(String string) {
        var query = "SELECT budgetID FROM budget WHERE budgetName = ?;";
        int id = 0;
        try (var stat = GetConnection.getConn().prepareStatement(query);) {
            stat.setString(1, string);
            var rs = stat.executeQuery();
            if (rs.next()) {
                id = rs.getInt("budgetID");
            }
        } catch (SQLException e) {
            System.out.println("Error Getting budget ID: " + e.getMessage());
        }
        return id;
    }
    
    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTotalBudgetAmount() {
        return totalBudgetAmount;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(long totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Map<Category, List<Long>> getAllocatedCategories() {
        return allocatedCategories;
    }

    public void setAllocatedCategories(Map<Category, List<Long>> allocatedCategories) {
        this.allocatedCategories = allocatedCategories;
    }
}
