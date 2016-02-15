package domain;

import java.util.ArrayList;

/**
 * @author Joris
 */
public class Category {
    
    private String name;
    private ArrayList<Expense> expenses;

    public Category(String name) {
        this.setName(name);
        this.setExpenses(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Expense> getExpenses() {
        return this.expenses;
    }

    private void setName(String name) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("Name is null");
        }
        this.name = name;
    }

    private void setExpenses(ArrayList<Expense> expenses) {
        if(expenses == null) {
            throw new IllegalArgumentException("Expenses is null");
        }
        this.expenses = expenses;
    }
    
    // Bi-directional association
    public void addExpense(Expense expense) {
        if(expense == null) {
            throw new IllegalArgumentException("Expense is null");
        }
        this.getExpenses().add(expense);
        expense.setCategory(this);
    }
    
    // Bi-directional association
    public void removeExpense(Expense expense) {
        if(expense == null) {
            throw new IllegalArgumentException("Expense is null");
        }
        if(!this.getExpenses().contains(expense)) {
            throw new IllegalArgumentException("Expense does not exist");
        }
        this.getExpenses().remove(expense);
    }

}
