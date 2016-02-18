package domain;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joris
 */
public class CategoryTest {
    
    String defaultName;
    String differentName;
    ArrayList<Expense> defaultExpenses;
    ArrayList<Expense> differentExpenses;
    Expense defaultExpense;
    
    @Before
    public void setUp() {
        defaultName = "Boodschappen";
        differentName = "Belastingen";
        defaultExpenses = new ArrayList<>();
        differentExpenses = new ArrayList<>();
        defaultExpense = new Expense(new Category("Boodschappen"), "Toiletpapier", 3.14, Priority.TOP);
        differentExpenses.add(defaultExpense);
    }
    
    // Constructors
    @Test
    public void Category_1_arg_maakt_Category() {
        Category category = new Category(defaultName);
        assertEquals(category.getName(), defaultName);
        assertEquals(category.getExpenses(), defaultExpenses);
    }
    
    @Test
    public void Category_1_arg_maakt_Category_met_lege_expenses() {
        Category category = new Category(defaultName);
        assertTrue(category.getExpenses().isEmpty());
    }
    
    @Test
    public void Category_2_args_maakt_Category() {
        Category category = new Category(defaultName, defaultExpenses);
        assertEquals(category.getName(), defaultName);
        assertEquals(category.getExpenses(), defaultExpenses);
    }
            
    // Null checks
    @Test (expected = IllegalArgumentException.class)
    public void setName_gooit_exception_bij_name_null() {
        Category category = new Category(defaultName);
        category.setName(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void setName_gooit_exception_bij_name_lege_String() {
        Category category = new Category(defaultName);
        category.setName("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void setExpenses_gooit_exception_bij_expenses_null() {
        Category category = new Category(defaultName);
        category.setExpenses(null);
    }
    
    // Other methods
    @Test (expected = IllegalArgumentException.class)
    public void addExpense_gooit_exception_bij_expense_null() {
        Category category = new Category(defaultName, null);
        category.addExpense(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void removeExpense_gooit_exception_bij_expense_null() {
        Category category = new Category(defaultName, defaultExpenses);
        category.removeExpense(null);
    }
    
    @Test
    public void addExpense_voegt_expense_toe() {
        Category category = new Category(defaultName, defaultExpenses);
        category.addExpense(defaultExpense);
        assertEquals(category.getExpenses().get(0), defaultExpense);
    }
    
    @Test
    public void removeExpense_verwijdert_expense() {
        Category category = new Category(defaultName);
        category.addExpense(defaultExpense);
        category.removeExpense(defaultExpense);
        assertEquals(category.getExpenses().size(), 0);
    }
    
}
