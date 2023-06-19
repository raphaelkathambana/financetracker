package main;

import util.Category;
import util.parentCategory;

public class CategoryExamples {
    public static void main(String[] args) {
        Category salaryCategory = new Category("Salary", "Regular salary income", parentCategory.INCOME.getCategory());
        Category freelanceIncomeCategory = new Category("Freelance Income", "Income from freelance work", parentCategory.INCOME.getCategory());

        Category housingCategory = new Category("Housing", "Expenses related to housing", parentCategory.EXPENSE.getCategory());

        Category transportationCategory = new Category("Transportation", "Expenses on transportation", parentCategory.EXPENSE.getCategory());
        Category foodCategory = new Category("Food and Dining", "Expenses on food and dining", parentCategory.EXPENSE.getCategory());
        // ... and so on

        // Setting up further subcategories
        Category rentCategory = new Category("Rent/Mortgage", "Monthly rent or mortgage payments", housingCategory);
        Category utilitiesCategory = new Category("Utilities", "Expenses for utilities like electricity, water, etc.",housingCategory);
        // ... and so on

        System.out.println(salaryCategory.getParentCategory().getName());        
        System.out.println(freelanceIncomeCategory);
        System.out.println(housingCategory);
        System.out.println(transportationCategory);
        System.out.println(foodCategory);
        System.out.println(rentCategory);
        System.out.println(utilitiesCategory.getParentCategory().getParentCategory().getName());



    }
}
