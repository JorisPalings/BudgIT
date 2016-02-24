package domain;

import java.util.ArrayList;

/**
 * @author Joris
 */
public class Category {
    
    private String name;
    private ArrayList<Expense> expenses;

    public Category(String name) {
        this(name, new ArrayList<>());
    }

    public Category(String name, ArrayList<Expense> expenses) {
        this.setName(name);
        this.setExpenses(expenses);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Expense> getExpenses() {
        return this.expenses;
    }

    public void setName(String name) {
        if(name == null || name.trim().equals("")) {
            throw new DomainException("Name is null");
        }
        this.name = name;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        if(expenses == null) {
            throw new DomainException("Expenses is null");
        }
        this.expenses = expenses;
    }
    
    public void addExpense(Expense expense) {
        if(expense == null) {
            throw new DomainException("Expense is null");
        }
        this.getExpenses().add(expense);
    }
    
    public void removeExpense(Expense expense) {
        if(expense == null) {
            throw new DomainException("Expense is null");
        }
        if(!this.getExpenses().contains(expense)) {
            throw new DomainException("Expense does not exist");
        }
        this.getExpenses().remove(expense);
    }
    
    public boolean contains(Expense expense) {
        if(expense == null) {
            throw new DomainException("Expense is null");
        }
        boolean contains = false;
        for(Expense e: this.getExpenses()) {
            if(e.equals(expense)) {
                contains = true;
            }
        }
        return contains;
    }
    
    public double getTotal() {
        double total = 0;
        for(Expense e: this.getExpenses()) {
            total += e.getAmount();
        }
        return total;
    }

}