package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joris
 */
public class Category {
    
    private int id;
    private static int globalId = 0;
    private String name;
    private List<Expense> expenses;

    public Category() {
        this("New category");
    }

    public Category(String name) {
        this(name, new ArrayList<>());
    }

    public Category(String name, ArrayList<Expense> expenses) {
        this.setId(globalId ++);
        this.setName(name);
        this.setExpenses(expenses);
    }
    
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public Expense getExpense(int id) {
        if(id < 0) {
            throw new DomainException("Id is negative");
        }
        for(Expense e: this.getExpenses()) {
            if(e.getId() == id) {
                return e;
            }
        }
        throw new DomainException("No expense with that id");
    }

    public List<Expense> getExpenses() {
        return this.expenses;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    @Override
    public boolean equals(Object o) {
        return(o instanceof Category
                && ((Category) o).getId() == this.getId()
                && ((Category) o).getName().equals(this.getName())
                && ((Category) o).getExpenses() == this.getExpenses());
    }

}
