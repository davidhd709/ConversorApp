
package conversorapp;


import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author henry
 */

public class UnidadesMetricas {
    private HashMap<String, Double> conversionFactors;

    public UnidadesMetricas() {
        conversionFactors = new HashMap<>();
        conversionFactors.put("Milímetro", 0.001);
        conversionFactors.put("Centímetro", 0.01);
        conversionFactors.put("Metro", 0.1);
        conversionFactors.put("Millas", 0.000621371);
        conversionFactors.put("Kilómetros", 0.000001);
    }

    public double convert(String DeUnidadMetrica, String AUnidadMetrica, double amount) {
        double fromFactor = conversionFactors.get(DeUnidadMetrica);
        double toFactor = conversionFactors.get(AUnidadMetrica);
        return amount * fromFactor / toFactor;
    }

    public Set<String> getUnidadMetrica() { 
        return conversionFactors.keySet();
    }
}
