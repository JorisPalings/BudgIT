package controller;

import domain.Application;
import domain.Category;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Joris
 */
@RestController
@RequestMapping("/categories")
public class CategoryRestController {
    
    @Autowired
    Application application;
    
    // GET all categories
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Integer, Category>> getCategories(){
        if(application.getCategories().isEmpty()) {
            return new ResponseEntity<Map<Integer, Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<Integer, Category>>(application.getCategories(), HttpStatus.OK);
    }
    
    // GET category catId
    @RequestMapping(value="/{catId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable int catId) {
        Category category = application.getCategory(catId);
        if(category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(application.getCategory(catId), HttpStatus.OK);
    }
    
    // POST category
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        if(application.contains(category)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        application.addCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/categories/{catId}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }    
    
    // UPDATE category catId
    @RequestMapping(value="/{catId}", method = RequestMethod.PUT)
    public ResponseEntity<Category> getCategory(@PathVariable int catId, @RequestBody Category category) {
        Category currentCategory = application.getCategory(catId);
        if(currentCategory == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        currentCategory.setName(category.getName());
        return new ResponseEntity<Category>(application.getCategory(catId), HttpStatus.OK);
    }
    
    // DELETE category catId
    @RequestMapping(value="/{catId}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable int catId) {
        Category category = application.getCategory(catId);
        if(category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        application.removeCategory(application.getCategory(catId));
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

}