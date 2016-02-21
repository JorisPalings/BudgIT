package domain;

import database.Database;
import database.DatabaseFactory;
import java.util.HashSet;

/**
 * @author Joris
 */
public class Application {
    
    private Database database;
    
    public Application(String databaseType) {
        DatabaseFactory databaseFactory = new DatabaseFactory();
        this.database = databaseFactory.createDatabase(databaseType);
    }
    
    public Database getDatabase() {
        return this.database;
    }
    
    public HashSet<Category> getCategories() {
        return this.getDatabase().getCategories();
    }
    
    public void addCategory(Category category) {
        this.getDatabase().addCategory(category);
    }
    
    public void removeCategory(Category category) {
        this.getDatabase().removeCategory(category);
    }
    
    public void addExpense(Expense expense, Category category) {
        this.getDatabase().addExpense(expense, category);
    }
    
    public void removeExpense(Expense expense, Category category) {
        this.getDatabase().removeExpense(expense, category);
    }
    
    public boolean contains(Category category) {
        if(category == null) {
            throw new DomainException("Category is null");
        }
        return this.getDatabase().getCategories().contains(category);
    }
    
    public boolean contains(Category category, Expense expense) {
        if(category == null) {
            throw new DomainException("Category is null");
        }
        if(expense == null) {
            throw new DomainException("Expense is null");
        }
        return category.contains(expense);
    }
    
    public double getCategoryTotal(Category category) {
        if(category == null) {
            throw new DomainException("Category is null");
        }
        return category.getTotal();
    }
    
    public double getTotal() {
        double total = 0;
        for(Category c: this.getCategories()) {
            total += getCategoryTotal(c);
        }
        return total;
    }

}
