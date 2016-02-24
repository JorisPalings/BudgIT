/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import database.DatabaseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joris
 */
public class ApplicationTest {
    
    Application defaultApplication;
    Application differentApplication;
    Category defaultCategory;
    Category differentCategory;
    Expense defaultExpense;
    Expense differentExpense;
    
    @Before
    public void setUp() {
        defaultApplication = new Application("Stub");
        differentApplication = null;
        defaultCategory = new Category("Transport");
        differentCategory = new Category("Belastingen");
        defaultExpense = new Expense(defaultCategory, "Busabonnement", 3.14);
        differentExpense = new Expense(differentCategory, "Water", 9001);
    }
    
    @After
    public void tearDown() {
        defaultExpense = null;
        differentExpense = null;
        defaultCategory = null;
        differentCategory = null;
        defaultApplication = null;
        differentApplication = null;
    }
    
    // Constructor
    @Test
    public void Application_maakt_Application_bij_geldige_args() {
        differentApplication = new Application("Stub");
        assertTrue(differentApplication != null);
    }
    
    // Null checks
    @Test (expected = DatabaseException.class)
    public void addCategory_gooit_exception_bij_category_null() {
        defaultApplication.addCategory(null);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_category_null() {
        defaultApplication.changeCategoryName(null, differentCategory.getName());
    }
    
    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_name_null() {
        defaultApplication.changeCategoryName(defaultCategory, null);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_name_lege_String() {
        defaultApplication.changeCategoryName(defaultCategory, "");
    }
    
    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_name_spaties() {
        defaultApplication.changeCategoryName(defaultCategory, "             ");
    }
    
    @Test (expected = DatabaseException.class)
    public void removeCategory_gooit_exception_bij_category_null() {
        defaultApplication.addCategory(null);
    }
    
    @Test (expected = DatabaseException.class)
    public void addExpense_gooit_exception_bij_expense_null() {
        defaultApplication.addExpense(null, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void addExpense_gooit_exception_bij_category_null() {
        defaultApplication.addExpense(defaultExpense, null);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseCategory_gooit_exception_bij_expense_null() {
        defaultApplication.changeExpenseCategory(null, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseCategory_gooit_exception_bij_category_null() {
        defaultApplication.changeExpenseCategory(defaultExpense, null);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseName_gooit_exception_bij_expense_null() {
        defaultApplication.changeExpenseName(null, differentExpense.getName());
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseName_gooit_exception_bij_name_null() {
        defaultApplication.changeExpenseName(defaultExpense, null);
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseName_gooit_exception_bij_name_lege_String() {
        defaultApplication.changeExpenseName(defaultExpense, "");
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseName_gooit_exception_bij_name_spaties() {
        defaultApplication.changeExpenseName(defaultExpense, "               ");
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpenseAmount_gooit_exception_bij_expense_null() {
        defaultApplication.changeExpenseAmount(null, differentExpense.getAmount());
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseAmount_gooit_exception_bij_amount_negatief() {
        defaultApplication.changeExpenseAmount(defaultExpense, -9000);
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseAmount_gooit_exception_bij_amount_nul() {
        defaultApplication.changeExpenseAmount(defaultExpense, 0);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeExpensePriority_gooit_exception_bij_expense_null() {
        defaultApplication.changeExpensePriority(null, Priority.TOP);
    }
    
    @Test (expected = DomainException.class)
    public void changeExpenseAmount_gooit_exception_bij_priority_null() {
        defaultApplication.changeExpensePriority(defaultExpense, null);
    }
    
    @Test (expected = DatabaseException.class)
    public void removeExpense_gooit_exception_bij_expense_null() {
        defaultApplication.removeExpense(null, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void removeExpense_gooit_exception_bij_category_null() {
        defaultApplication.removeExpense(defaultExpense, null);
    }
    
    @Test (expected = DomainException.class)
    public void contains_1_arg_gooit_exception_bij_category_null() {
        defaultApplication.contains(null);
    }
    
    @Test (expected = DomainException.class)
    public void contains_2_args_gooit_exception_bij_category_null() {
        defaultApplication.contains(null, defaultExpense);
    }
    
    @Test (expected = DomainException.class)
    public void contains_2_args_gooit_exception_bij_expense_null() {
        defaultApplication.contains(defaultCategory, null);
    }
    
    @Test (expected = DomainException.class)
    public void getCategoryTotal_gooit_exception_bij_category_null() {
        defaultApplication.getCategoryTotal(null);
    }
    
    // Other methods: Exceptions
    @Test (expected = DatabaseException.class)
    public void addCategory_gooit_exception_bij_bestaande_category() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addCategory(defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void changeCategoryName_gooit_exception_bij_reeds_bestaande_naam() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addCategory(differentCategory);
        defaultApplication.changeCategoryName(defaultCategory, differentCategory.getName());
    }
    
    @Test (expected = DatabaseException.class)
    public void removeCategory_gooit_exception_bij_onbestaande_category() {
        defaultApplication.removeCategory(defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void addExpense_gooit_exception_bij_bestaande_expense() {
        defaultApplication.addExpense(defaultExpense, defaultCategory);
        defaultApplication.addExpense(defaultExpense, defaultCategory);
    }
    
    @Test (expected = DatabaseException.class)
    public void removeExpense_gooit_exception_bij_onbestaande_expense() {
        defaultApplication.removeExpense(defaultExpense, defaultCategory);
    }
    
    // Other methods: Correct functioning
    @Test
    public void addCategory_voegt_nieuwe_category_toe_bij_onbestaande_category() {
        defaultApplication.addCategory(defaultCategory);
        assertTrue(defaultApplication.contains(defaultCategory));
    }
    
    @Test
    public void changeCategoryName_verandert_name_bij_onbestaande_name() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.changeCategoryName(defaultCategory, differentCategory.getName());
        assertTrue(defaultCategory.getName().equals(differentCategory.getName()));
    }
    
    @Test
    public void removeCategory_verwijdert_categorie_bij_bestaande_categorie() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.removeCategory(defaultCategory);
        assertFalse(defaultApplication.contains(defaultCategory));
    }
    
    @Test
    public void addExpense_voegt_nieuwe_expense_toe_bij_onbestaande_expense() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addExpense(defaultExpense, defaultCategory);
        assertTrue(defaultApplication.contains(defaultCategory, defaultExpense));
    }
    
    @Test
    public void changeExpenseCategory_verwijdert_expense_bij_oorspronkelijke_category() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addCategory(differentCategory);
        defaultApplication.addExpense(defaultExpense, defaultCategory);
        defaultApplication.changeExpenseCategory(defaultExpense, differentCategory);
        assertFalse(defaultApplication.contains(defaultCategory, defaultExpense));
    }
    
    @Test
    public void changeExpenseCategory_voegt_expense_bij_toe_bij_nieuwe_category() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addCategory(differentCategory);
        defaultApplication.addExpense(defaultExpense, defaultCategory);
        defaultApplication.changeExpenseCategory(defaultExpense, differentCategory);
        assertTrue(defaultApplication.contains(differentCategory, defaultExpense));
    }
    
    @Test
    public void changeExpenseName_verandert_name_bij_geldige_name() {
        defaultApplication.changeExpenseName(defaultExpense, "Treinbiljet");
        assertEquals(defaultExpense.getName(), "Treinbiljet");
    }
    
    @Test
    public void changeExpenseAmount_verandert_amount_bij_geldige_amount() {
        defaultApplication.changeExpenseAmount(defaultExpense, 666.66);
        assertEquals(defaultExpense.getAmount(), 666.66, 0.01);
    }
    
    @Test
    public void changeExpensePriority_verandert_priority_bij_geldige_priority() {
        defaultApplication.changeExpensePriority(defaultExpense, Priority.LOW);
        assertEquals(defaultExpense.getPriority(), Priority.LOW);
    }
    
    @Test
    public void removeExpense_verwijdert_expense_bij_bestaande_expense() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addExpense(defaultExpense, defaultCategory);
        defaultApplication.removeExpense(defaultExpense, defaultCategory);
        assertFalse(defaultCategory.contains(defaultExpense));
    }
    
    @Test
    public void contains_1_arg_geeft_true_bij_bestaande_category() {
        defaultApplication.addCategory(defaultCategory);
        assertTrue(defaultApplication.contains(defaultCategory));
    }
    
    @Test
    public void contains_2_args_geeft_true_bij_bestaande_category_en_expense() {
        defaultCategory.addExpense(defaultExpense);
        defaultApplication.addCategory(defaultCategory);
        assertTrue(defaultApplication.contains(defaultCategory, defaultExpense));
    }
    
    @Test
    public void getCategoryTotal_geeft_correct_totaal_bij_bestaande_category() {
        defaultCategory.addExpense(defaultExpense);
        defaultCategory.addExpense(defaultExpense);
        defaultApplication.addCategory(defaultCategory);
        assertTrue(defaultExpense.getAmount() * 2 
                == defaultApplication.getCategoryTotal(defaultCategory));
    }
    
    @Test
    public void getTotal_geeft_correct_totaal() {
        defaultCategory.addExpense(defaultExpense);
        defaultApplication.addCategory(defaultCategory);
        
        differentCategory.addExpense(differentExpense);
        defaultApplication.addCategory(differentCategory);
        
        assertEquals(defaultCategory.getTotal() + differentCategory.getTotal(),
                defaultApplication.getTotal(), 0.01);
    }
    
}
