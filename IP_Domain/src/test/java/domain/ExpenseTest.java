package domain;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Joris
 */
public class ExpenseTest {

    private Category defaultCategory;
    private Category differentCategory;
    private String defaultName;
    private String differentName;
    private double defaultAmount;
    private double differentAmount;
    private Priority defaultPriority;
    private Priority differentPriority;
    private LocalDateTime defaultDateTime;
    private LocalDateTime differentDateTime;
    
    @Before
    public void setUp() {
        defaultCategory = new Category("Huishouden");
        differentCategory = new Category("Boodschappen");
        defaultName = "Nieuwe auto";
        differentName = "Boodschappen";
        defaultAmount = 3.14;
        differentAmount = 9001;
        defaultPriority = Priority.MEDIUM;
        differentPriority = Priority.TOP;
        defaultDateTime = LocalDateTime.now();
        differentDateTime = LocalDateTime.MAX;
    }
       
    @After
    public void tearDown() {
        defaultCategory = null;
        differentCategory = null;
        defaultName = null;
        differentName = null;
        defaultAmount = 0;
        differentAmount = 0;
        defaultPriority = null;
        differentPriority = null;
        defaultDateTime = null;
        differentDateTime = null;
    }
       
    // Constructor functionality
    @Test
    public void Expense_3_args_maakt_Expense() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        assertEquals(expense.getCategory(), defaultCategory);
        assertEquals(expense.getName(), defaultName);
        assertEquals(expense.getAmount(), defaultAmount, 0.01);
    }
    
    @Test
    public void Expense_3_args_maakt_Expense_met_MEDIUM() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        assertEquals(expense.getCategory(), defaultCategory);
        assertEquals(expense.getName(), defaultName);
        assertEquals(expense.getAmount(), defaultAmount, 0.01);
        assertEquals(expense.getPriority(), Priority.MEDIUM);
    }
    
    @Test
    public void Expense_4_args_maakt_Expense() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount, defaultPriority);
        assertEquals(expense.getCategory(), defaultCategory);
        assertEquals(expense.getName(), defaultName);
        assertEquals(expense.getAmount(), defaultAmount, 0.01);
        assertEquals(expense.getPriority(), defaultPriority);
    }

    // Null checks
    @Test (expected = DomainException.class)
    public void Expense_3_args_gooit_exception_bij_categorie_null() {
        Expense expense = new Expense(null, defaultName, defaultAmount);
    }

    @Test (expected = DomainException.class)
    public void Expense_3_args_gooit_exception_bij_name_null() {
        Expense expense = new Expense(defaultCategory, null, 3.14);
    }

    @Test (expected = DomainException.class)
    public void Expense_3_args_gooit_exception_bij_name_lege_String() {
        Expense expense = new Expense(defaultCategory, "", 3.14);
    }

    @Test (expected = DomainException.class)
    public void Expense_3_args_gooit_exception_bij_amount_negatief() {
        Expense expense = new Expense(defaultCategory, null, -3.14);
    }

    @Test (expected = DomainException.class)
    public void Expense_3_args_gooit_exception_bij_amount_nul() {
        Expense expense = new Expense(defaultCategory, null, 0);
    }

    @Test (expected = DomainException.class)
    public void Expense_4_args_gooit_exception_bij_priority_null() {
        Expense expense = new Expense(defaultCategory, null, 3.14, null);
    }
    
    @Test (expected = DomainException.class)
    public void setCategory_gooit_exception_bij_categorie_null() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setCategory(null);
    }

    @Test (expected = DomainException.class)
    public void setName_gooit_exception_bij_name_null() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setName(null);
    }

    @Test (expected = DomainException.class)
    public void setName_gooit_exception_bij_name_lege_String() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setName("");
    }

    @Test (expected = DomainException.class)
    public void setAmount_gooit_exception_bij_amount_negatief() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setAmount(-3.14);
    }

    @Test (expected = DomainException.class)
    public void setAmount_gooit_exception_bij_amount_nul() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setAmount(0);
    }

    @Test (expected = DomainException.class)
    public void setPriority_gooit_exception_bij_priority_null() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setPriority(null);
    }
    
    // Setter functionality
    @Test 
    public void setCategory_verandert_categorie() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setCategory(differentCategory);
        assertEquals(expense.getCategory(), differentCategory);
    }

    @Test
    public void setName_verandert_naam() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setName(differentName);
        assertEquals(expense.getName(), differentName);
    }

    @Test
    public void setAmount_verandert_amount() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setAmount(differentAmount);
        assertEquals(expense.getAmount(), differentAmount, 0.01);
    }

    @Test
    public void setPriority_verandert_priority() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount, defaultPriority);
        expense.setPriority(differentPriority);
        assertEquals(expense.getPriority(), differentPriority);
    }

    @Test
    public void setDateTime_verandert_dateTime() {
        Expense expense = new Expense(defaultCategory, defaultName, defaultAmount);
        expense.setDateTime(differentDateTime);
        assertEquals(expense.getDateTime(), differentDateTime);
    }
    
}
