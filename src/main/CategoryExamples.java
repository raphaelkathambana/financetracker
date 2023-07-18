package main;

import util.Budget;
import util.Category;
import util.parentCategory;

public class CategoryExamples {
    public static void main(String[] args) {
        // "INSERT INTO Category (categoryID, name, description, parent_category_id)
        // VALUES ('C-003', 'Salary', 'Regular salary income', 'C-001');",
        Category salaryCategory = new Category("Salary", "Regular salary income", "C-003",
                parentCategory.INCOME.getCategory());
        Category freelanceIncomeCategory = new Category("Freelance Income", "Income from freelance work",
                parentCategory.INCOME.getCategory());

        // "INSERT INTO Category (categoryID, name, description, parent_category_id)
        // VALUES ('C-007', 'Housing', 'Expenses related to housing', 'C-002');",
        Category housingCategory = new Category("Housing", "Expenses related to housing",
                parentCategory.EXPENSE.getCategory());

        Category transportationCategory = new Category("Transportation", "Expenses on transportation",
                parentCategory.EXPENSE.getCategory());
        Category foodCategory = new Category("Food and Dining", "Expenses on food and dining",
                parentCategory.EXPENSE.getCategory());
        // ... and so on

        // Setting up further subcategories
        Category rentCategory = new Category("Rent/Mortgage", "Monthly rent or mortgage payments", housingCategory);
        Category utilitiesCategory = new Category("Utilities", "Expenses for utilities like electricity, water, etc.",
                housingCategory);
        // ... and so on

        System.out.println(salaryCategory.getParentCategory().getName());
        System.out.println(freelanceIncomeCategory);
        System.out.println(housingCategory);
        System.out.println(transportationCategory);
        System.out.println(foodCategory);
        System.out.println(rentCategory);
        System.out.println(utilitiesCategory.getParentCategory().getParentCategory().getName());

        var list = Category.getCategoryFromDb();
        System.out.println("Category: " + list.get(15).getName() + " and Parent Category: "
                + list.get(15).getParentCategory().getName());

        Budget budget = new Budget("2023-01-01", "2023-01-31");

        budget.allocateCategoryBudget(list.get(4), 1000);
        budget.allocateCategoryBudget(list.get(5), 500);
        budget.allocateCategoryBudget(list.get(6), 2000);

        budget.trackExpense(list.get(5), 160);
        budget.generateBudgetReport();
    }
}