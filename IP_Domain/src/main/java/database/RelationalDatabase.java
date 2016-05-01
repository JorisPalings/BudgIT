package database;

import domain.Category;
import domain.Expense;
import domain.Priority;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author Joris
 */
public class RelationalDatabase implements Database {
    
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    public RelationalDatabase(String PUname) {
        factory = Persistence.createEntityManagerFactory(PUname);
        manager = factory.createEntityManager();
    }
    
    @Override
    public void closeConnection() throws DatabaseException {
        try {
            manager.close();
            factory.close();
        } catch(Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public Map<Integer, Category> getCategories() throws DatabaseException {
        try {
            TypedQuery<Category> query = manager.createQuery("SELECT c FROM Category c", Category.class);
            List<Category> categoryList = query.getResultList();
            Map<Integer, Category> categoryMap = new TreeMap<>();
            for(Category c: categoryList) {
                categoryMap.put(c.getId(), c);
            }
            return categoryMap;
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: getCategories" + e.getMessage(), e);
        }
    }

    @Override
    public void addCategory(Category category) throws DatabaseException {
        try {
            manager.getTransaction().begin();
            manager.persist(category);
            manager.flush();
            manager.getTransaction().commit();
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: addCategory" + e.getMessage(), e);
        }
    }

    @Override
    public void changeCategoryName(Category category, String name) throws DatabaseException {
        try {
            manager.getTransaction().begin();
            Category oldCategory = manager.find(Category.class, category.getId());
            oldCategory.setName(name);
            manager.flush();
            manager.getTransaction().commit();
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: changeCategoryName" + e.getMessage(), e);
        }
    }

    @Override
    public void removeCategory(Category category) throws DatabaseException {
        try {
            manager.getTransaction().begin();
            manager.remove(category);
            manager.flush();
            manager.getTransaction().commit();
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: removeCategory" + e.getMessage(), e);
        }
    }

    @Override
    public void addExpense(Expense expense, Category category) throws DatabaseException {
        try {
            manager.getTransaction().begin();
            Category categoryToAddTo = manager.find(Category.class, category.getId());
            categoryToAddTo.addExpense(expense);
            manager.flush();
            manager.getTransaction().commit();
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: addExpense" + e.getMessage(), e);
        }
    }

    // Over categories loopen?
    @Override
    public void changeExpenseCategory(Expense expense, Category category) {
        throw new UnsupportedOperationException("Not supported yet.4"); //To change body of generated methods, choose Tools | Templates.
        //merge
    }

    @Override
    public void changeExpenseName(Expense expense, String name) throws DatabaseException {
        try {
            manager.getTransaction().begin();
            Expense expenseToChange = manager.find(Expense.class, expense.getId());
            expenseToChange.setName(name);
            manager.flush();
            manager.getTransaction().commit();
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: changeExpenseName" + e.getMessage(), e);
        }
    }

    @Override
    public void changeExpenseAmount(Expense expense, double amount) throws DatabaseException {
        try {
            manager.getTransaction().begin();
            Expense expenseToChange = manager.find(Expense.class, expense.getId());
            expenseToChange.setAmount(amount);
            manager.flush();
            manager.getTransaction().commit();
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: changeExpenseAmount" + e.getMessage(), e);
        }
    }

    @Override
    public void changeExpensePriority(Expense expense, Priority priority) throws DatabaseException {
        try {
            manager.getTransaction().begin();
            Expense expenseToChange = manager.find(Expense.class, expense.getId());
            expenseToChange.setPriority(priority);
            manager.flush();
            manager.getTransaction().commit();
        } catch(Exception e) {
            throw new DatabaseException("RelationalDatabase: changeExpensePriority" + e.getMessage(), e);
        }
    }

    // Via category of manager.remove?
    @Override
    public void removeExpense(Expense expense, Category category) {
        throw new UnsupportedOperationException("Not supported yet.8"); //To change body of generated methods, choose Tools | Templates.
        //update>delete
    }

}
