package domain;

import java.util.HashSet;

/**
 * @author Joris
 */
public class Application {
    
    private static Application uniqueInstance = null;
    private HashSet<Category> categories;
    
    private Application() {
        this.categories = new HashSet<>();
    }
    
    public static Application getUniqueInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Application();
        }
        return uniqueInstance;
    }
    
    public HashSet<Category> getCategories() {
        return this.categories;
    }
    
    public void addCategory(Category category) {
        if(category == null) {
            throw new IllegalArgumentException("Category is null");
        }
        if(this.getCategories().contains(category)) {
            throw new IllegalArgumentException("Category already exists");
        }
        this.getCategories().add(category);
    }
    
    public void removeCategory(Category category) {
        if(category == null) {
            throw new IllegalArgumentException("Category is null");
        }
        if(!this.getCategories().contains(category)) {
            throw new IllegalArgumentException("Category does not exists");
        }
        this.getCategories().remove(category);
    }
    
    public void addExpense(Expense expense, Category category) {
        if(expense == null) {
            throw new IllegalArgumentException("Expense is null");
        }
        if(category == null) {
            throw new IllegalArgumentException("Category is null");
        }
        if(category.getExpenses().contains(expense)) {
            throw new IllegalArgumentException("Expense already exists");
        }
        category.addExpense(expense);
    }
    
    public void removeExpense(Expense expense, Category category) {
        if(expense == null) {
            throw new IllegalArgumentException("Expense is null");
        }
        if(category == null) {
            throw new IllegalArgumentException("Category is null");
        }
        boolean removed = false;
        for(Category c: this.getCategories()) {
            if(c.equals(category)) {
                for(Expense e: c.getExpenses()) {
                    if(e.equals(expense)) {
                        c.removeExpense(e);
                        removed = true;
                    }
                }
            }
        }
        if(!removed) {
            throw new IllegalArgumentException("Expense does not exists");
        }
    }
    
    public double getCategoryTotal(Category category) {
        return category.getTotal();
    }
    
    public double getTotal() {
        double total = 0;
        for(Category c: this.getCategories()) {
            total += c.getTotal();
        }
        return total;
    }

}
