package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Budget;
import util.Category;
import util.GetConnection;
import util.parentCategory;

public class CategoryExamples {
    private static final String INCOME_ID = parentCategory.INCOME.getCategory().getId();
    private static final String EXPENSE_ID = parentCategory.EXPENSE.getCategory().getId();

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

        var list = getCategoryFromDb();
        System.out.println("Category: " + list.get(15).getName() + " and Parent Category: "
                + list.get(15).getParentCategory().getName());

        Budget budget = new Budget("2023-01-01", "2023-01-31");

        budget.allocateCategoryBudget(list.get(4), 1000);
        budget.allocateCategoryBudget(list.get(5), 500);
        budget.allocateCategoryBudget(list.get(6), 2000);

        budget.trackExpense(list.get(5), 160);

        budget.generateBudgetReport();
    }

    public static List<Category> getCategoryFromDb() {
        var query = "SELECT * FROM `category`;";
        List<Category> list = new ArrayList<>();
        Category category = null;

        try (var connect = GetConnection.getConn();
                var stat = connect.prepareStatement(query);) {
            var rs = stat.executeQuery();

            while (rs.next()) {
                if (rs.getString(4) == null && rs.getString(1).equals(INCOME_ID)) {
                    list.add(parentCategory.INCOME.getCategory());
                }
                if (rs.getString(4) == null && rs.getString(1).equals(EXPENSE_ID)) {
                    list.add(parentCategory.EXPENSE.getCategory());
                }
                if (rs.getString(4) != null) {
                    category = new Category(rs.getString(2), rs.getString(3), rs.getString(1),
                            getParentCategoryFromId(rs.getString(4)));
                    list.add(category);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    public static Category getCategoryFromId(String id) {
        var query = "SELECT * FROM Category WHERE categoryID = ?;";
        Category category = null;
        try (var connect = GetConnection.getConn();
                var stat = connect.prepareStatement(query);) {
            stat.setString(1, id);

            var rs = stat.executeQuery();
            rs.next();
            if (rs.getString(1).equals(INCOME_ID)) {
                category = parentCategory.INCOME.getCategory();
            }
            if (rs.getString(1).equals(EXPENSE_ID)) {
                category = parentCategory.EXPENSE.getCategory();
            }
            if (!rs.getString(1).equals(INCOME_ID) && !rs.getString(1).equals(EXPENSE_ID)) {
                category = new Category(rs.getString(2), rs.getString(3), rs.getString(1),
                        getParentCategoryFromId(rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("Problem: " + e.getMessage());
        }
        return category;
    }

    public static Category getParentCategoryFromId(String parentId) {
        var query = "SELECT * FROM Category WHERE categoryID = ?;";
        Category category = null;
        try (var connect = GetConnection.getConn();
                var stat = connect.prepareStatement(query);) {
            stat.setString(1, parentId);

            var rs = stat.executeQuery();
            rs.next();
            if (rs.getString(1).equals(INCOME_ID)) {
                category = parentCategory.INCOME.getCategory();
            }
            if (rs.getString(1).equals(EXPENSE_ID)) {
                category = parentCategory.EXPENSE.getCategory();
            }
            if (!rs.getString(1).equals(INCOME_ID) && !rs.getString(1).equals(EXPENSE_ID)) {
                category = new Category(rs.getString(2), rs.getString(3), rs.getString(1),
                        getParentCategoryFromId(rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("Problem: " + e.getMessage());
        }
        return category;
    }

    public static Category searchForCategory(List<Category> stuff, String searchValue) {
        for (Category category : stuff) {
            if (category.getName().equals(searchValue)) {
                return category;
            }
        }
        return null;
    }
}