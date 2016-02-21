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

    public void setCategory(Category category) {
        if(category == null) {
            throw new DomainException("Category is null");
        }
        this.category = category;
    }

    public void setName(String name) {
        if(name == null || name.trim().equals("")) {
            throw new DomainException("Name is null or an empty String");
        }
        this.name = name;
    }

    public void setAmount(double amount) {
        if(amount <= 0) {
            throw new DomainException("Amount is negative or zero");
        }
        this.amount = amount;
    }
    
    public void setPriority(Priority priority) {
        if(priority == null) {
            throw new DomainException("Priority is null");
        }
        this.priority = priority;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        if(dateTime == null) {
            throw new DomainException("DateTime is null");
        }
        this.dateTime = dateTime;
    }
    
}
