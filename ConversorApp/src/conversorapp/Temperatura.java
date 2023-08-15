package conversorapp;

/**
 *
 * @author henry
 */
import java.util.HashMap;
import java.util.Set;

public class Temperatura {
    public double convert(double temperatura, String DeTemperatura, String ATemperatura) {
        if (DeTemperatura.equals("Celsius")) {
            if (ATemperatura.equals("Fahrenheit")) {
                return celsiusToFahrenheit(temperatura);
            } else if (ATemperatura.equals("Kelvin")) {
                return celsiusToKelvin(temperatura);
            }
        } else if (DeTemperatura.equals("Fahrenheit")) {
            if (ATemperatura.equals("Celsius")) {
                return fahrenheitToCelsius(temperatura);
            } else if (ATemperatura.equals("Kelvin")) {
                return fahrenheitToKelvin(temperatura);
            }
        } else if (DeTemperatura.equals("Kelvin")) {
            if (ATemperatura.equals("Celsius")) {
                return kelvinToCelsius(temperatura);
            } else if (ATemperatura.equals("Fahrenheit")) {
                return kelvinToFahrenheit(temperatura);
            }
        }
        return temperatura; // Default: no conversion needed
    }

    private double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private double kelvinToFahrenheit(double kelvin) {
        return kelvin * 9 / 5 - 459.67;
    }
}
