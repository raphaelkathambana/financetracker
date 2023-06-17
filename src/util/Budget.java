package util;

public class Budget {
    private Category category;
    private double budgetAmount;
    private double progress;

    public Budget(Category category, double budgetAmount, double progress) {
        this.category = category;
        this.budgetAmount = budgetAmount;
        this.progress = progress;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}