package database;

import domain.Category;
import domain.Expense;
import java.util.HashSet;

/**
 * @author Joris
 */
public interface Database {
    
    public HashSet<Category> getCategories();
    
    public void addCategory(Category category);
    
    public void removeCategory(Category category);
    
    public void addExpense(Expense expense, Category category);
    
    public void removeExpense(Expense expense, Category category);
    
}
