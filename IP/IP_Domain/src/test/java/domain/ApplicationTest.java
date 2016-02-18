/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
    Expense defaultExpense;
    
    @Before
    public void setUp() {
        defaultApplication = Application.getUniqueInstance();
        differentApplication = null;
        defaultCategory = new Category("Transport");
        defaultExpense = new Expense(defaultCategory, "Busabonnement", 3.14);
    }
    
    // Constructor
    @Test
    public void getUniqueInstance_maakt_Application() {
        Application differentApplication = Application.getUniqueInstance();
        assertTrue(differentApplication != null);
    }
    
    // Null checks
    @Test (expected = IllegalArgumentException.class)
    public void addCategory_gooit_exception_bij_category_null() {
        defaultApplication.addCategory(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void removeCategory_gooit_exception_bij_category_null() {
        defaultApplication.addCategory(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void addExpense_gooit_exception_bij_expense_null() {
        defaultApplication.addExpense(null, defaultCategory);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void addExpense_gooit_exception_bij_category_null() {
        defaultApplication.addExpense(defaultExpense, null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void removeExpense_gooit_exception_bij_expense_null() {
        defaultApplication.removeExpense(null, defaultCategory);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void removeExpense_gooit_exception_bij_category_null() {
        defaultApplication.removeExpense(defaultExpense, null);
    }
    
    // Other methods
    @Test (expected = IllegalArgumentException.class)
    public void addCategory_gooit_exception_bij_bestaande_categorie() {
        defaultApplication.addCategory(defaultCategory);
        defaultApplication.addCategory(defaultCategory);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void removeCategory_gooit_exception_bij_onbestaande_categorie() {
        defaultApplication.removeCategory(defaultCategory);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void addExpense_gooit_exception_bij_bestaande_expense() {
        defaultApplication.addExpense(defaultExpense, defaultCategory);
        defaultApplication.addExpense(defaultExpense, defaultCategory);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void removeExpense_gooit_exception_bij_onbestaande_expense() {
        defaultApplication.removeExpense(defaultExpense, defaultCategory);
    }
    
}
