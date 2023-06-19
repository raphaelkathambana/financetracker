package util;

public enum parentCategory {

    INCOME(new Category("Income", "All sources of income", null)),
    EXPENSE(new Category("Expenses", "All types of expenses", null));

    private final Category category;

    parentCategory(Category c) {
        this.category = c;
    }

    public Category getCategory() {
        return category;
    }
}
