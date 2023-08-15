
package conversorapp;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author henry
 */


public class Moneda {
    private HashMap<String, Double> exchangeRates;

    public Moneda() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("Peso Colombiano", 1.00);
        exchangeRates.put("Peso Mexicano", 3800.0);
        exchangeRates.put("Peso Argentino", 110.0);
        exchangeRates.put("Dólar", 0.00026);
        exchangeRates.put("Euro", 0.00022);
        exchangeRates.put("Libras Esterlinas", 0.00019);
    }

    public double convert(String DeMoneda, String AMoneda, double amount) {
        double fromRate = exchangeRates.get(DeMoneda);
        double toRate = exchangeRates.get(AMoneda);
        return amount * toRate / fromRate;
    }

    public Set<String> getMoneda() {
        return exchangeRates.keySet();
    }
}

