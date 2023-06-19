package util;

public class Category {
    private String name;
    private String description;
    private parentCategory parentCategory;

    public Category(String name, String description, parentCategory parentCategory) {
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public parentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(parentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

}