package util;

public enum parentCategory {

    INCOME(new Category("Income", "All sources of Income", "C-001", new Category("", ""))),
    EXPENSE(new Category("Expenses", "All types of Expenses", "C-002", new Category("", "")));

    private final Category category;

    parentCategory(Category c) {
        this.category = c;
    }

    public Category getCategory() {
        return this.category;
    }
}
