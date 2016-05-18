package controller;

import domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Joris
 */
@Controller
@RequestMapping(value="/rates")
public class ExchangeRateController {
    @Autowired
    private Application application;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getExchangeRates() {
        return new ModelAndView("rates", "exchangeRates", application.getExchangeRates());
    }

}