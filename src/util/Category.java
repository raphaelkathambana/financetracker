package util;

public class Category {
    private String name;
    private String description;
    private Category parentCategory;
    private String id;

    public Category(String name, String description, Category parentCategory) {
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }
    
    public Category(String name, String description, String id, Category parentCategory) {
        this.name = name;
        this.description = description;
        this.id = id;
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

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}