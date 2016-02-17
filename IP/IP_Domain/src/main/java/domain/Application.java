package domain;

import java.util.HashSet;

/**
 * @author Joris
 */
public class Application {
    
    private HashSet<Category> categories;
    
    public Application() {
        this.categories = new HashSet<>();
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
    
    public void removeExpense(Expense expense) {
        if(expense == null) {
            throw new IllegalArgumentException("Expense is null");
        }
        boolean removed = false;
        for(Category c: this.getCategories()) {
            if(c.getExpenses().contains(expense)) {
                c.removeExpense(expense);
                removed = true;
            }
        }
        if(!removed) {
            throw new IllegalArgumentException("Expense does not exists");
        }
    }

}
