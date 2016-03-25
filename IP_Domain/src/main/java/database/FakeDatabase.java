package database;

import domain.Category;
import domain.Expense;
import domain.Priority;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Joris
 */
public class FakeDatabase implements Database {
    
    private Map<Integer, Category> categories;
    
    public FakeDatabase() {
        this.categories = new TreeMap<>();
        categories.put(1, new Category("ExampleCategory1"));
        categories.get(1).addExpense(new Expense("ExampleExpense1", 9001));
        categories.get(1).addExpense(new Expense("ExampleExpense2", 666));
        categories.put(2, new Category("ExampleCategory2"));
        categories.get(2).addExpense(new Expense("ExampleExpense3", 123.45));
    }
    
    @Override
    public Map<Integer, Category> getCategories() {
        return this.categories;
    }

    @Override
    public void addCategory(Category category) {
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        if(this.getCategories().containsValue(category)) {
            throw new DatabaseException("Category already exists");
        }
        this.getCategories().put(category.getId(), category);
    }
    
    @Override
    public void changeCategoryName(Category category, String name) {
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        if(!(this.getCategories().containsValue(category))) {
            throw new DatabaseException("Category does not exist");
        }
        for(Category c: this.getCategories().values()) {
            if(c.getName().equals(name)) {
                throw new DatabaseException("Category with that name already exists");
            }
        }
        category.setName(name);
    }
    
    @Override
    public void removeCategory(Category category) {
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        if(!this.getCategories().containsValue(category)) {
            throw new DatabaseException("Category does not exist");
        }
        this.getCategories().remove(category.getId());
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
    public void changeExpenseCategory(Expense expense, Category category) {
        if(expense == null) {
            throw new DatabaseException("Expense is null");
        }
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        Category originalCategory = null;
        for(Category c: this.getCategories().values()) {
            if(c.getExpenses().contains(expense)) {
                originalCategory = c;
            }
        }
        category.addExpense(expense);
        originalCategory.removeExpense(expense);
    }
    
    @Override
    public void changeExpenseName(Expense expense, String name) {
        if(expense == null) {
            throw new DatabaseException("Expense is null");
        }
        expense.setName(name);
    }
    
    @Override
    public void changeExpenseAmount(Expense expense, double amount) {
        if(expense == null) {
            throw new DatabaseException("Expense is null");
        }
        expense.setAmount(amount);
    }
    
    @Override
    public void changeExpensePriority(Expense expense, Priority priority) {
        if(expense == null) {
            throw new DatabaseException("Expense is null");
        }
        expense.setPriority(priority);
    }
    
    @Override
    public void removeExpense(Expense expense, Category category) {
        if(expense == null) {
            throw new DatabaseException("Expense is null");
        }
        if(category == null) {
            throw new DatabaseException("Category is null");
        }
        Expense toRemove = null;
        for(Category c: this.getCategories().values()) {
            if(c.equals(category)) {
                for(Expense e: c.getExpenses()) {
                    if(e.equals(expense)) {
                        toRemove = e;
                    }
                }
            }
        }
        if(toRemove == null) {
            throw new DatabaseException("Expense does not exist");
        } else {
            category.getExpenses().remove(toRemove);
        }
    }

}
