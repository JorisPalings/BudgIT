package controller;

import domain.Application;
import domain.Category;
import domain.Expense;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Joris
 */
@Controller
// URL being mapped
@RequestMapping(value="/categories/{catId}/expenses")
public class ExpenseController {
    @Autowired
    private Application application;
    
    // Mapping GET requests with "/categories/{id}/expenses/new" to newExpenseForm.jsp
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView getNewExpenseForm(@ModelAttribute("category") Category category,
            @ModelAttribute("expense") Expense expense,
            @PathVariable int catId) {
        return new ModelAndView("newExpenseForm", "category", application.getCategory(catId));
    }
    
    // Taking form data from view and creating an Expense object with it
    // Redirecting POST requests back to category.jsp
    @RequestMapping(method = RequestMethod.POST)
    public String addExpense(@Valid @ModelAttribute("expense") Expense expense,
            @PathVariable int catId,
            BindingResult result) {
        if(result.hasErrors()) {
            return "newExpenseForm";
        }
        application.addExpense(expense, application.getCategory(catId));
        return "redirect:/categories.htm";
    }
    
    // Mapping GET requests with "/category/{id}/expenses/edit" to editCategoryForm.jsp
    // Getting the name from the view through the URL by using @PathVariable
    @RequestMapping(value = "/{expId}/edit", method = RequestMethod.GET)
    public ModelAndView getEditForm(@ModelAttribute("expense") Expense expense,
            @PathVariable int catId, 
            @PathVariable int expId) {
        Map<String, Object> model = new HashMap<>();
        model.put("category", application.getCategory(catId));
        model.put("expense", application.getCategory(catId).getExpense(expId));
        return new ModelAndView("editExpenseForm", "model", model);
    }
    
    // Taking form data from view and editing a Category object with it
    // Redirecting POST requests with "/category/{id}/edit" back to categories.jsp
    // Getting the id from the view through the URL by using @PathVariable
    @RequestMapping(value = "/{expId}/edit", method = RequestMethod.POST)
    public String saveEdit(@Valid @ModelAttribute("Expense") Expense expense,
            @PathVariable int catId,
            @PathVariable int expId,
            BindingResult result) {
        if(result.hasErrors()) {
            return "editExpenseForm";
        }
        Expense editedExpense = application.getCategory(catId).getExpense(expId);
        editedExpense.setName(expense.getName());
        editedExpense.setAmount(expense.getAmount());
        editedExpense.setPriority(expense.getPriority());
        return "redirect:/categories.htm";
    }
    
    // Redirecting all requests with "/category/{id}/expense/{id}/delete" to category.jsp
    // Getting the id from the view through the URL by using @PathVariable
    @RequestMapping(value="/{expId}/delete")
    public String deleteExpense(@PathVariable int catId,
            @PathVariable int expId) {
        application.removeExpense(
                application.getCategory(catId).getExpense(expId), 
                application.getCategory(catId));
        return "redirect:/categories/" + catId + ".htm";
    }
    
}