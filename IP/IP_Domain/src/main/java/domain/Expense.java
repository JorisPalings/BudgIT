package domain;

import java.time.LocalDateTime;

/**
 * @author Joris
 */
public class Expense {

    private Category category;
    private String name;
    private double amount;
    private Priority priority;
    private LocalDateTime dateTime;

    public Expense(Category category, String name, 
            double amount) {
        this(category, name, amount, Priority.MEDIUM);
    }
    
    public Expense(Category category, String name, 
            double amount, Priority priority) {
        this.setCategory(category);
        this.setName(name);
        this.setAmount(amount);
        this.setPriority(priority);
        this.setDateTime(LocalDateTime.now());
    }

    public Category getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }
    
    public Priority getPriority() {
        return this.priority;
    }
    
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    // Protected for bi-directional association
    protected void setCategory(Category category) {
        if(category == null) {
            throw new IllegalArgumentException("Category is null");
        }
        this.category = category;
    }

    private void setName(String name) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("Name is null");
        }
        this.name = name;
    }

    private void setAmount(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Amount is negative or zero");
        }
        this.amount = amount;
    }
    
    private void setPriority(Priority priority) {
        if(priority == null) {
            throw new IllegalArgumentException("Priority is null");
        }
        this.priority = priority;
    }
    
    private void setDateTime(LocalDateTime dateTime) {
        if(dateTime == null) {
            throw new IllegalArgumentException("DateTime is null");
        }
        this.dateTime = dateTime;
    }
    
}
