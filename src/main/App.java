package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import util.Category;
import util.Report;
import util.Transaction;
import util.parentCategory;

import alice.bye.Program;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
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
        expenses.add(new Transaction("2021-01-11", 20, foodCategory));
        expenses.add(new Transaction("2021-01-12", 30, transportationCategory));
        expenses.add(new Transaction("2021-01-13", 40, foodCategory));
        expenses.add(new Transaction("2021-01-14", 50, foodCategory));
        expenses.add(new Transaction("2021-01-15", 60, foodCategory));
        expenses.add(new Transaction("2021-01-16", 10, foodCategory));
        expenses.add(new Transaction("2021-01-16", 10, housingCategory));

        // data for income
        var income = new ArrayList<Transaction>();
        income.add(new Transaction("2021-01-10", 100, salaryCategory));
        income.add(new Transaction("2021-01-11", 200, salaryCategory));
        income.add(new Transaction("2021-01-12", 300, salaryCategory));
        income.add(new Transaction("2021-01-13", 400, freelanceIncomeCategory));
        income.add(new Transaction("2021-01-14", 500, freelanceIncomeCategory));
        income.add(new Transaction("2021-01-15", 600, freelanceIncomeCategory));
        var report = new Report("Expense Summary", "2021-01-10", "2021-01-30", expenses);

        report.generateReport();
                Properties mySql = new Properties();
        try (FileReader in = new FileReader("db.properties")) {
            mySql.load(in);
        } catch (IOException e) {
            System.out.println("Error loading db.properties from classpath." + e);
        }
        String exportUrl = mySql.getProperty("export");
        // report.exportReport(exportUrl);

        System.setProperty("org.alice.ide.rootDirectory", "./");
        final Program story = new Program();
        story.initializeInFrame(args);
        story.setActiveScene(story.getMyScene());

    }
}
