package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * @author Joris
 * Using http://fixer.io/
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRates {

    private Map<String, Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
    
}
