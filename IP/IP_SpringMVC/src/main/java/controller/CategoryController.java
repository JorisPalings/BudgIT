package controller;

import domain.Application;
import domain.Category;
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
// URLs being mapped
@RequestMapping(value="/categories")
public class CategoryController {
    // Using the dependency in applicationContext.xml
    @Autowired
    private Application application;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCategories() {
        // String viewName (jsp), String modelName (passed object), Object modelObject
        // Passing the entire application here instead of just the categories,
        // so we can access getTotal() from the view as well
        return new ModelAndView("categories", "application", application);
    }
    
    // Getting the id from the view through the URL by using @PathVariable
    @RequestMapping(value="/{catId}", method = RequestMethod.GET)
    public ModelAndView getCategory(@PathVariable int catId) {
        // Passing the entire application here instead of just the categories,
        // so we can access getTotal() from the view as well
        return new ModelAndView("category", "category", application.getCategory(catId));
    }
    
    // Mapping GET requests with "/category/new" to newCategoryForm.jsp
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String getNewCategoryForm(@ModelAttribute("category") Category category) {
        return "newCategoryForm";
    }
    
    // Taking form data from view and creating a Category object with it
    // Redirecting POST requests back to categories.jsp
    @RequestMapping(method = RequestMethod.POST)
    public String addCategory(@Valid @ModelAttribute("category") Category category,
            BindingResult result) {
        if(result.hasErrors()) {
            return "newCategoryForm";
        }
        application.addCategory(category);
        return "redirect:/categories.htm";
    }
    
    // Mapping GET requests with "/category/{id}/edit" to editCategoryForm.jsp
    // Getting the id from the view through the URL by using @PathVariable
    @RequestMapping(value = "/{catId}/edit", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable int catId) {
        return new ModelAndView("editCategoryForm", "category", application.getCategory(catId));
    }
    
    // Taking form data from view and editing a Category object with it
    // Redirecting POST requests with "/category/{id}/edit" back to categories.jsp
    // Getting the id from the view through the URL by using @PathVariable
    @RequestMapping(value = "/{catId}/edit", method = RequestMethod.POST)
    public String saveEdit(@Valid @ModelAttribute("category") Category category,
            @PathVariable int catId,
            BindingResult result) {
        if(result.hasErrors()) {
            return "editCategoryForm";
        }
        application.getCategory(catId).setName(category.getName());
        return "redirect:/categories.htm";
    }
    
    // Redirecting all requests with "/category/{id}/delete" to categories.jsp
    // Getting the id from the view through the URL by using @PathVariable
    @RequestMapping(value="/{catId}/delete")
    public String deleteCategory(@PathVariable int catId) {
        application.removeCategory(application.getCategory(catId));
        return "redirect:/categories.htm";
    }

}