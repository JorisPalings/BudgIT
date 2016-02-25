package domain;

import java.util.ArrayList;
import org.junit.After;
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
        defaultExpense = new Expense("Toiletpapier", 3.14, Priority.TOP);
        differentExpenses.add(defaultExpense);
    }
        
    @After
    public void tearDown() {
        defaultName = null;
        differentName = null;
        defaultExpenses = null;
        differentExpenses = null;
        defaultExpense = null;
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
    @Test (expected = DomainException.class)
    public void setName_gooit_exception_bij_name_null() {
        Category category = new Category(defaultName);
        category.setName(null);
    }
    
    @Test (expected = DomainException.class)
    public void setName_gooit_exception_bij_name_lege_String() {
        Category category = new Category(defaultName);
        category.setName("");
    }
    
    @Test (expected = DomainException.class)
    public void setName_gooit_exception_bij_name_spaties() {
        Category category = new Category(defaultName);
        category.setName("          ");
    }
    
    @Test (expected = DomainException.class)
    public void setExpenses_gooit_exception_bij_expenses_null() {
        Category category = new Category(defaultName);
        category.setExpenses(null);
    }
    
    // Other methods: Exceptions
    @Test (expected = DomainException.class)
    public void addExpense_gooit_exception_bij_expense_null() {
        Category category = new Category(defaultName, null);
        category.addExpense(null);
    }
    
    @Test (expected = DomainException.class)
    public void removeExpense_gooit_exception_bij_expense_null() {
        Category category = new Category(defaultName, defaultExpenses);
        category.removeExpense(null);
    }
    
    @Test (expected = DomainException.class)
    public void contains_gooit_exception_bij_expense_null() {
        Category category = new Category(defaultName, defaultExpenses);
        category.contains(null);
    }
    
    // Other methods: correct functioning
    @Test
    public void setName_verandert_name_bij_geldige_name() {
        Category category = new Category(defaultName, defaultExpenses);
        category.setName(differentName);
        assertEquals(category.getName(), differentName);
    }
    
    @Test
    public void setExpenses_verandert_expenses_bij_geldige_expenses() {
        Category category = new Category(defaultName, defaultExpenses);
        category.setExpenses(differentExpenses);
        assertEquals(category.getExpenses(), differentExpenses);
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
