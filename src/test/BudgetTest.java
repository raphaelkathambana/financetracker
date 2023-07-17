package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import util.Budget;
import util.Category;
import util.parentCategory;

public class BudgetTest {
    @Test
    public void testTrackExpense() {
        Category foodCategory = new Category("Food and Dining", "Expenses on food and dining", parentCategory.EXPENSE.getCategory());
        Budget budget = new Budget("2023-01-01", "2023-12-31");
        long expense = 1000;
        budget.allocateCategoryBudget(foodCategory, expense);

        // Track expenses
        budget.trackExpense(foodCategory, 800);

        for (Map.Entry<Category, List<Long>> entry : budget.getAllocatedCategories().entrySet()) {
            List<Long> allocatedAmount = entry.getValue();

            long total = allocatedAmount.get(0) + allocatedAmount.get(1);
            assertEquals(total, expense);
        }
    }
}
