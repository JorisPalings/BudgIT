# BudgIT

This is the home of the four projects I made for Internet Programming for my studies in Applied Information Technology.
Through these four projects, I've learned how to work with JPA and JDBC, Spring MVC, RESTful services, HTTP and jQuery's AJAX functions.

1. IP_Domain contains some simple entities, used as the domain for the other projects:
    - An Application class that serves as both a service class and a facade
    - A Database interface, defining the behavior of the concrete database types that implement it: 
        - MemoryDatabase: A fake database, which is actually just a Map
        - RelationalDatabase: A real, relational database using JPA
    - A Category class with name, expenses and id fields, representing a category containing expenses
    - An Expense class with name, amount, priority, dateTime and id fields, representing a single expense within a category
    - A Priority enum containing the possible priotities for an expense
    - Some custom Exception classes: DatabaseException and DomainException
    - An ExchangeRates class, to demonstrate a simple REST API call


2. IP_SpringMVC is a simple Spring MVC project with three Controllers that uses the domain classes from IP_Domain:
    - A CategoryController class, mapping Category-related GET and POST requests to their respective JSP views
    - An ExpenseController class, mapping Expense-related GET and POST requests to their respective JSP views
    - An ExchangeRateController class, mapping ExchangeRates-related GET requests to their respective JSP views
    - This project is internationalized (i18n) using Spring messages, locales and properties files
    - Forms are validated using Spring validation annotations and properties files
    - XML is used for configuration


3. IP_REST provides a REST API for the domain classes from IP_Domain using a Spring RestController
    - The CategoryRestController maps GET, POST, PUT and DELETE requests to their respective actions on the domain objects inside the relational database
    - Returns ResponseEntities with HTTP status codes
    - Output is JSON, formatted and indented using Jackson
    - CORS is enabled for all HTTP methods
    - Java config is used for configuration


4. IP_jQuery uses jQuery to provide an interface for the REST API provided by IP_REST
    - Uses jQuery's $.ajax function to send a GET request to the API and $.each to display the returned categories
    - Uses jQuery's $.ajac function to send DELETE requests to the API
    - Uses jQuery's $.load function to include simple HTML files like the nav and the footer
    - Uses the jQuery .properties i18n library and the jQuery Cookie library for easy locale cookie handling for i18n
