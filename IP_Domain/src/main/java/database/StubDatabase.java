package database;

import domain.Category;
import domain.Expense;
import java.util.HashSet;

/**
 * @author Joris
 */
public class StubDatabase implements Database {
    
    private HashSet<Category> categories;
    
    public StubDatabase() {
        this.categories = new HashSet<>();
    }
    
    @Override
    public HashSet<Category> getCategories() {
        return this.categories;
    }

    @Override
    public void addCategory(Category category) {
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        if(this.getCategories().contains(category)) {
            throw new DatabaseException("Category already exists");
        }
        this.getCategories().add(category);
    }
    
    @Override
    public void removeCategory(Category category) {
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        if(!this.getCategories().contains(category)) {
            throw new DatabaseException("Category does not exist");
        }
        this.getCategories().remove(category);
    }
    
    @Override
    public void addExpense(Expense expense, Category category) {
        if(expense == null) {
            throw new DatabaseException("Expense is null");
        }
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        if(category.getExpenses().contains(expense)) {
            throw new DatabaseException("Expense already exists");
        }
        category.addExpense(expense);
    }
    
    @Override
    public void removeExpense(Expense expense, Category category) {
        if(expense == null) {
            throw new DatabaseException("Expense is null");
        }
        if(category == null) {
            throw new DatabaseException("Category is null");
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
            throw new DatabaseException("Expense does not exist");
        }
    }

}
