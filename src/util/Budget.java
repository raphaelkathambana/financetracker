package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Budget {
    private String startDate;
    private String endDate;
    private double totalBudgetAmount;
    private double totalExpenses;
    private Map<Category, List<Double>> allocatedCategories;

    public Budget(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBudgetAmount = 0.0;
        this.totalExpenses = 0.0;
        this.allocatedCategories = new HashMap<>();
    }

    public void setTotalBudgetAmount(double totalIncome) {
        this.totalBudgetAmount = totalIncome;
    }

    public void allocateCategoryBudget(Category category, double amount) {
        totalBudgetAmount += amount;
        List<Double> amountMap = new ArrayList<>();
        amountMap.add(amount);
        amountMap.add(0.0);
        allocatedCategories.put(category, amountMap);
    }

    public void trackExpense(Category category, double expenseAmount) {
        totalExpenses += expenseAmount;

        if (allocatedCategories.containsKey(category)) {
            double allocatedAmount = allocatedCategories.get(category).get(0);
            double remainingBudget = allocatedAmount - expenseAmount;

            if (remainingBudget < 0) {
                System.out.println("You have exceeded the budget for category: " + category);
                // Generate an alert or notification for exceeding the budget
            }

            List<Double> amountMap = new ArrayList<>();
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

        for (Map.Entry<Category, List<Double>> entry : allocatedCategories.entrySet()) {
            Category category = entry.getKey();
            List<Double> allocatedAmount = entry.getValue();

            System.out.println("Category: " + category.getName());
            System.out.println("Allocated Amount: " + (allocatedAmount.get(0) + allocatedAmount.get(1)));
            System.out.println("Remaining Budget: " + allocatedAmount.get(0));
        }
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

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Map<Category, List<Double>> getAllocatedCategories() {
        return allocatedCategories;
    }

    public void setAllocatedCategories(Map<Category, List<Double>> allocatedCategories) {
        this.allocatedCategories = allocatedCategories;
    }
}
