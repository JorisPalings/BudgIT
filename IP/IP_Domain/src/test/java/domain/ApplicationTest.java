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
    
    // Other methods
    @Test (expected = DatabaseException.class)
    public void addCategory_gooit_exception_bij_bestaande_category() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addCategory(defaultCategory);
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
    
    @Test
    public void addCategory_voegt_nieuwe_category_toe_bij_onbestaande_category() {
        defaultApplication.addCategory(defaultCategory);
        assertTrue(defaultApplication.contains(defaultCategory));
    }
    
    @Test
    public void addExpense_voegt_nieuwe_expense_toe_bij_onbestaande_expense() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addExpense(defaultExpense, defaultCategory);
        assertTrue(defaultApplication.contains(defaultCategory, defaultExpense));
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
