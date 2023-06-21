package util;

public enum parentCategory {

    INCOME(new Category("Income", "All sources of Income", null)),
    EXPENSE(new Category("Expenses", "All types of Expenses", null));

    private final Category category;

    parentCategory(Category c) {
        this.category = c;
    }

    public Category getCategory() {
        return this.category;
    }
}
