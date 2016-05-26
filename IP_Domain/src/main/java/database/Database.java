package database;

import domain.Category;
import domain.Expense;
import domain.Priority;
import java.util.Map;

/**
 * @author Joris
 */
public interface Database {
    
    public void closeConnection();
    
    public Map<Integer, Category> getCategories();
    
    public void addCategory(Category category);
    
    public void changeCategoryName(Category category, String name);
    
    public void removeCategory(Category category);
    
    public void addExpense(Expense expense, Category category);
    
    public void changeExpenseName(Expense expense, String name);
    
    public void changeExpenseAmount(Expense expense, double amount);
    
    public void changeExpensePriority(Expense expense, Priority priority);
    
    public void removeExpense(Expense expense, Category category);
    
}
