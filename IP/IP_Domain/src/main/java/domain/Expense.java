package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Joris
 */
@Entity
public class Expense implements Serializable {

    @Id @GeneratedValue
    private int id;
    
    @NotNull(message="{error.NameNotNull}") @NotBlank(message="{error.NameNotNull}")
    private String name;
    
    @DecimalMin(value="0.01", message="{error.AmountNotNegativeOrZero}")
    private Double amount;

    @NotNull(message="{error.PriorityNotNull}")
    private Priority priority;
    
    @NotNull(message="{error.DateTimeNotNull}")
    private LocalDateTime dateTime;
    
    public Expense() {
        this("New expense", 0.01);
    }

    public Expense(String name, double amount) {
        this(name, amount, Priority.MEDIUM);
    }
    
    public Expense(String name, double amount, Priority priority) {
        this.setId(id);
        this.setName(name);
        this.setAmount(amount);
        this.setPriority(priority);
        this.setDateTime(LocalDateTime.now());
    }

    public int getId() {
        return this.id;
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
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    @Override
    public boolean equals(Object o) {
        return(o instanceof Expense
                && ((Expense) o).getId() == this.getId()
                && ((Expense) o).getName().equals(this.getName())
                && ((Expense) o).getAmount() == this.getAmount()
                && ((Expense) o).getPriority() == this.getPriority()
                && ((Expense) o).getDateTime() == this.getDateTime());
    }
    
}
