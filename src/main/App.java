package main;

import java.util.ArrayList;

import util.Category;
import util.Report;
import util.Transaction;
import util.User;
import util.parentCategory;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Add an income transaction
        User.addIncomeTransaction(1, 1000.0, "Salary", "2023-06-24");
        // Retrieve expenses for a user
        User.getExpensesForUser(1);

        // income categories
        var salaryCategory = new Category("Salary", "Regular salary income",
                parentCategory.INCOME.getCategory());
        var freelanceIncomeCategory = new Category("Freelance Income", "Income from freelance work",
                parentCategory.INCOME.getCategory());

        // expense categories
        var housingCategory = new Category("Housing", "Expenses related to housing",
                parentCategory.EXPENSE.getCategory());

        var transportationCategory = new Category("Transportation", "Expenses on transportation",
                parentCategory.EXPENSE.getCategory());

        var foodCategory = new Category("Food and Dining", "Expenses on food and dining",
                parentCategory.EXPENSE.getCategory());

        // data for expenses
        var expenses = new ArrayList<Transaction>();
        expenses.add(new Transaction("2021-01-11", 20.00, foodCategory));
        expenses.add(new Transaction("2021-01-12", 30.00, transportationCategory));
        expenses.add(new Transaction("2021-01-13", 40.00, foodCategory));
        expenses.add(new Transaction("2021-01-14", 50.00, foodCategory));
        expenses.add(new Transaction("2021-01-15", 60.00, foodCategory));
        expenses.add(new Transaction("2021-01-16", 10.00, foodCategory));
        expenses.add(new Transaction("2021-01-16", 10.00, housingCategory));

        // data for income
        var income = new ArrayList<Transaction>();
        income.add(new Transaction("2021-01-10", 100.00, salaryCategory));
        income.add(new Transaction("2021-01-11", 200.00, salaryCategory));
        income.add(new Transaction("2021-01-12", 300.00, salaryCategory));
        income.add(new Transaction("2021-01-13", 400.00, freelanceIncomeCategory));
        income.add(new Transaction("2021-01-14", 500.00, freelanceIncomeCategory));
        income.add(new Transaction("2021-01-15", 600.00, freelanceIncomeCategory));

        var report = new Report("Expense Summary", "2021-01-10", "2021-01-30", expenses);

        report.generateReport();
        // report.exportReport("C:\\Users\\maya1\\Desktop\\JavaOOPClass\\oop2class\\financetracker\\src\\util");
    }
}
