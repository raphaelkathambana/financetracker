package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Category {
    private String name;
    private String description;
    private Category parentCategory;
    private String id;
    private static final String INCOME_ID = util.parentCategory.INCOME.getCategory().getId();
    private static final String EXPENSE_ID = util.parentCategory.EXPENSE.getCategory().getId();

    

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
    public static List<Category> getCategoryFromDb() {
        var query = "SELECT * FROM `category`;";
        List<Category> list = new ArrayList<>();
        Category category = null;

        try (var connect = GetConnection.getConn();
                var stat = connect.prepareStatement(query);) {
            var rs = stat.executeQuery();

            while (rs.next()) {
                if (rs.getString(4) == null && rs.getString(1).equals(INCOME_ID)) {
                    list.add(util.parentCategory.INCOME.getCategory());
                }
                if (rs.getString(4) == null && rs.getString(1).equals(EXPENSE_ID)) {
                    list.add(util.parentCategory.EXPENSE.getCategory());
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
                category = util.parentCategory.INCOME.getCategory();
            }
            if (rs.getString(1).equals(EXPENSE_ID)) {
                category = util.parentCategory.EXPENSE.getCategory();
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
                category = util.parentCategory.INCOME.getCategory();
            }
            if (rs.getString(1).equals(EXPENSE_ID)) {
                category = util.parentCategory.EXPENSE.getCategory();
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