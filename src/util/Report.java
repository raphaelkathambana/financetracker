package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

public class Report {
    private String reportType;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Transaction> transactions;

    public Report(String reportType, String startDateString, String endDateString, List<Transaction> transactions) {
        this.reportType = reportType;
        this.startDate = LocalDate.parse(startDateString);
        this.endDate = LocalDate.parse(endDateString);
        this.transactions = transactions;
    }

    public void generateReport() {
        System.out.println("Report Type: " + reportType);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);

        switch (reportType) {
            case "Income Statement":
                calculateIncomeStatement();
                break;
            case "Expense Summary":
                calculateExpenseSummary();
                break;
            case "Category-wise Spending Report":
                analyzeCategorySpending();
                break;
            case "Budget Variance Report":
                compareBudgetVariance();
                break;
            case "Trend Analysis":
                analyzeTrends();
                break;
            default:
                System.out.println("Invalid report type.");
        }
    }

    public void exportReport(String filePath) {
        String fileName = filePath + "/" + reportType.replace(" ", "_") + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName)))) {
            // Write the report content to the file
            writer.println("Report Type: " + reportType);
            writer.println("Start Date: " + startDate);
            writer.println("End Date: " + endDate);

            switch (reportType) {
                case "Income Statement":
                    writeIncomeStatement(writer);
                    break;
                case "Expense Summary":
                    writeExpenseSummary(writer);
                    break;
                case "Category-wise Spending Report":
                    writeCategorySpending(writer);
                    break;
                case "Budget Variance Report":
                    writeBudgetVariance(writer);
                    break;
                case "Trend Analysis":
                    writeTrendAnalysis(writer);
                    break;
                default:
                    writer.println("Invalid report type.");
            }
            System.out.println("Report exported to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting report: " + e.getMessage());
        }
    }

    private void calculateIncomeStatement() {
        double totalIncome = 0;
        double totalExpenses = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getCategory().getParentCategory() == parentCategory.INCOME.getCategory()) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getCategory().getParentCategory() == parentCategory.EXPENSE.getCategory()) {
                totalExpenses += transaction.getAmount();
            }
        }

        double netProfitLoss = totalIncome - totalExpenses;

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Net Profit/Loss: " + netProfitLoss);
    }

    private void calculateExpenseSummary() {
        System.out.println("Expense Summary:");
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().getParentCategory() == parentCategory.EXPENSE.getCategory()) {
                System.out.println(transaction.getCategory().getName() + ": " + transaction.getAmount());
            }
        }
    }

    private void analyzeCategorySpending() {
        System.out.println("Category-wise Spending Report:");
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().getParentCategory() == parentCategory.EXPENSE.getCategory()) {
                System.out.println(transaction.getCategory().getName() + ": " + transaction.getAmount());
            }
        }
    }

    private void compareBudgetVariance() {
        // Implement budget variance calculation and comparison
        // based on allocated budget and actual expenses
        System.out.println("Budget Variance Report:");
    }

    private void analyzeTrends() {
        // Implement trend analysis based on financial data over multiple time periods
        System.out.println("Trend Analysis:");
    }

    private void writeIncomeStatement(PrintWriter writer) {
        double totalIncome = 0;
        double totalExpenses = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getCategory().getParentCategory() == parentCategory.INCOME.getCategory()) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getCategory().getParentCategory() == parentCategory.EXPENSE.getCategory()) {
                totalExpenses += transaction.getAmount();
            }
        }

        double netProfitLoss = totalIncome - totalExpenses;

        writer.println("Total Income: " + totalIncome);
        writer.println("Total Expenses: " + totalExpenses);
        writer.println("Net Profit/Loss: " + netProfitLoss);
    }

    private void writeExpenseSummary(PrintWriter writer) {
        writer.println("Expense Summary:");
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().getParentCategory() == parentCategory.EXPENSE.getCategory()) {
                writer.println(transaction.getCategory().getName() + ": " + transaction.getAmount());
            }
        }
    }

    private void writeCategorySpending(PrintWriter writer) {
        writer.println("Category-wise Spending Report:");
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().getParentCategory() == parentCategory.EXPENSE.getCategory()) {
                writer.println(transaction.getCategory().getName() + ": " + transaction.getAmount());
            }
        }
    }

    private void writeBudgetVariance(PrintWriter writer) {
        // Implement budget variance calculation and comparison
        // based on allocated budget and actual expenses

        writer.println("Budget Variance Report:");
    }

    private void writeTrendAnalysis(PrintWriter writer) {
        // Implement trend analysis based on financial data over multiple time periods

        writer.println("Trend Analysis:");
    }
}
