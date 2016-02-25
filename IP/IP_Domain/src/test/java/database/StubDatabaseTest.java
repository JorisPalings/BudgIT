package database;

import domain.Category;
import domain.DomainException;
import domain.Expense;
import domain.Priority;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Joris
 */
public class StubDatabaseTest {
    
    StubDatabase defaultDatabase;
    StubDatabase differentDatabase;
    Category defaultCategory;
    Category differentCategory;
    Expense defaultExpense;
    
    @Before
    public void setUp() {
        defaultDatabase = new StubDatabase();
        differentDatabase = new StubDatabase();
        defaultCategory = new Category("Verzekeringen");
        differentCategory = new Category("Voeding");
        defaultExpense = new Expense("Omnium", 123.45);
    }
    
    @After
    public void tearDown() {
        defaultDatabase = null;
        differentDatabase = null;
        defaultCategory = null;
        differentCategory = null;
        defaultExpense = null;
    }
    
    // Constructors
    @Test
    public void StubDatabase_maakt_StubDatabase_aan() {
        assertTrue(defaultDatabase != null);
    }
    
    // Null checks
    @Test (expected = DatabaseException.class)
    public void addCategory_gooit_exception_bij_category_null() {
        defaultDatabase.addCategory(null);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_category_null() {
        defaultDatabase.changeCategoryName(null, "Varia");
    }

    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_name_null() {
        defaultDatabase.changeCategoryName(defaultCategory, null);
    }

    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_name_lege_String() {
        defaultDatabase.changeCategoryName(defaultCategory, "");
    }

    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_name_spaties() {
        defaultDatabase.changeCategoryName(defaultCategory, "          ");
    }
    
    @Test (expected = DatabaseException.class)
    public void removeCategory_gooit_exception_bij_category_null() {
        defaultDatabase.removeCategory(null);
    }
    
    @Test (expected = DatabaseException.class)
    public void addExpense_gooit_exception_bij_expense_null() {
        defaultDatabase.addExpense(null, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void addExpense_gooit_exception_bij_category_null() {
        defaultDatabase.addExpense(defaultExpense, null);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseCategory_gooit_exception_bij_expense_null() {
        defaultDatabase.changeExpenseCategory(null, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseCategory_gooit_exception_bij_category_null() {
        defaultDatabase.addExpense(defaultExpense, null);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseName_gooit_exception_bij_expense_null() {
        defaultDatabase.changeExpenseName(null, "Brandverzekering");
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseName_gooit_exception_bij_name_null() {
        defaultDatabase.changeExpenseName(defaultExpense, null);
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseName_gooit_exception_bij_name_lege_String() {
        defaultDatabase.changeExpenseName(defaultExpense, "");
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseName_gooit_exception_bij_name_spaties() {
        defaultDatabase.changeExpenseName(defaultExpense, "        ");
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseAmount_gooit_exception_bij_expense_null() {
        defaultDatabase.changeExpenseAmount(null, 777.77);
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseAmount_gooit_exception_bij_amount_negatief() {
        defaultDatabase.changeExpenseAmount(defaultExpense, -9000);
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseAmount_gooit_exception_bij_amount_nul() {
        defaultDatabase.changeExpenseAmount(defaultExpense, 0);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpensePriority_gooit_exception_bij_expense_null() {
        defaultDatabase.changeExpensePriority(null, Priority.LOW);
    }
    
    @Test (expected = DomainException.class)
    public void changeExpensePriority_gooit_exception_bij_priority_null() {
        defaultDatabase.changeExpensePriority(defaultExpense, null);
    }
    
    @Test (expected = DatabaseException.class)
    public void removeExpense_gooit_exception_bij_expense_null() {
        defaultDatabase.addExpense(defaultExpense, defaultCategory);
        defaultDatabase.removeExpense(null, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void removeExpense_gooit_exception_bij_category_null() {
        defaultDatabase.addExpense(defaultExpense, defaultCategory);
        defaultDatabase.removeExpense(defaultExpense, null);
    }
    
    // Other methods: Exceptions
    
    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_bestaande_name() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.addCategory(differentCategory);
        defaultDatabase.changeCategoryName(defaultCategory, "Voeding");
    }
    
    @Test (expected = DatabaseException.class)
    public void addExpense_gooit_exception_bij_bestaande_expense() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.addExpense(defaultExpense, defaultCategory);
        defaultDatabase.addExpense(defaultExpense, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void removedExpense_gooit_exception_bij_onbestaande_expense() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.removeExpense(defaultExpense, defaultCategory);
    }
    
    // Other methods: correct functioning
    @Test
    public void addCategory_voegt_categorie_toe_bij_geldige_category() {
        defaultDatabase.addCategory(defaultCategory);
        assertTrue(defaultDatabase.getCategories().contains(defaultCategory));
    }
    
    @Test
    public void changeCategoryName_verandert_naam_categorie_bij_geldige_args() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.changeCategoryName(defaultCategory, "Andere naam");
        assertEquals(defaultCategory.getName(), "Andere naam");
    }
    
    @Test
    public void removeCategory_verwijdert_categorie_bij_geldige_category() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.removeCategory(defaultCategory);
        assertFalse(defaultDatabase.getCategories().contains(defaultCategory));
    }
    
    @Test
    public void addExpense_voegt_expense_toe_bij_geldige_args() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.addExpense(defaultExpense, defaultCategory);
        assertTrue(defaultCategory.contains(defaultExpense));
    }
    
    @Test
    public void changeExpenseCategory_verandert_category_bij_geldige_args() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.addCategory(differentCategory);
        defaultDatabase.addExpense(defaultExpense, defaultCategory);
        defaultDatabase.changeExpenseCategory(defaultExpense, differentCategory);
        assertTrue(!(defaultCategory.contains(defaultExpense))
                && differentCategory.contains(defaultExpense));
    }
    
    @Test
    public void changeExpenseName_verandert_name_bij_geldige_args() {
        defaultDatabase.changeExpenseName(defaultExpense, "Andere naam");
        assertEquals(defaultExpense.getName(), "Andere naam");
    }
    
    @Test
    public void changeExpenseAmount_verandert_amount_bij_geldige_args() {
        defaultDatabase.changeExpenseAmount(defaultExpense, 3.14);
        assertEquals(defaultExpense.getAmount(), 3.14, 0.01);
    }
    
    @Test
    public void changeExpensePriority_verandert_priority_bij_geldige_args() {
        defaultDatabase.changeExpensePriority(defaultExpense, Priority.TOP);
        assertEquals(defaultExpense.getPriority(), Priority.TOP);
    }
    
    @Test
    public void removeExpense_verwijdert_expense_bij_geldige_args() {
        defaultDatabase.addCategory(defaultCategory);
        defaultDatabase.addExpense(defaultExpense, defaultCategory);
        defaultDatabase.removeExpense(defaultExpense, defaultCategory);
        assertFalse(defaultCategory.contains(defaultExpense));
    }

}
